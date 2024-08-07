package com.kh.works.board.mapper;

import com.kh.works.board.vo.BoardImgVo;
import com.kh.works.board.vo.BoardVo;
import com.kh.works.board.vo.CommentVo;
import com.kh.works.board.vo.WishBoardVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BoardMapper {

    @Insert("INSERT INTO BOARD\n" +
            "(\n" +
            "    BOARD_NO\n" +
            "    ,EMP_NO\n" +
            "    ,TITLE\n" +
            "    ,CONTENT\n" +
            "    ,CRTN_DATE\n" +
            "    ,MDFD_DATE\n" +
            ") VALUES\n" +
            "(\n" +
            "    SEQ_BOARD.NEXTVAL\n" +
            "    ,#{empNo}\n" +
            "    ,#{title}\n" +
            "    ,#{content}\n" +
            "    ,SYSTIMESTAMP\n" +
            "    ,NULL\n" +
            ")")
    int write(BoardVo vo);


    @Select("SELECT \n" +
            "    B.BOARD_NO\n" +
            "    ,E.NAME\n" +
            "    ,B.TITLE\n" +
            "    ,B.CRTN_DATE\n" +
            "    ,B.VIEW_COUNT\n" +
            "FROM BOARD B\n" +
            "JOIN EMPLOYEE E\n" +
            "ON B.EMP_NO = E.NO\n" +
            "WHERE B.DEL_YN = 'N'")
    List<BoardVo> getBoardList();

    @Select("SELECT \n" +
            "    B.BOARD_NO\n" +
            "    ,E.NAME\n" +
            "    ,B.TITLE\n" +
            "    ,B.CRTN_DATE\n" +
            "    ,B.VIEW_COUNT\n" +
            "FROM BOARD B\n" +
            "JOIN EMPLOYEE E\n" +
            "ON B.EMP_NO = E.NO\n" +
            "WHERE b.emp_no = #{empNo}" +
            "AND B.DEL_YN = 'N'")
    List<BoardVo> myBoardList(String empNo);

    @Select("""
            SELECT BOARD_NO, EMP_NO, TITLE, CONTENT, CRTN_DATE, MDFD_DATE
            FROM BOARD B
            WHERE B.BOARD_NO = #{boardNo}
            """)
    BoardVo getdetailBoard(String boardNo);

    @Update("<script>" +
            "UPDATE BOARD\n" +
            "<set>\n" +
            "   <if test=\"vo.title != null\">\n" +
            "       TITLE = #{vo.title},\n" +
            "   </if>\n" +
            "    <if test=\"vo.content != null\">\n" +
            "       CONTENT = #{vo.content},\n" +
            "    </if>\n" +
            "   MDFD_DATE = SYSTIMESTAMP\n" +
            "</set>\n" +
            "WHERE BOARD_NO = #{boardNo}\n" +
            "</script>")
    int editBoard(@Param("vo") BoardVo vo, @Param("boardNo") String boardNo);

    @Update("UPDATE BOARD SET DEL_YN = 'Y' WHERE BOARD_NO = #{boardNo}")
    int deleteBoard(@Param("boardNo") String boardNo);

    @Select("SELECT BOARD_NO\n" +
            "    ,E.NAME\n" +
            "    ,B.TITLE\n" +
            "    ,B.CRTN_DATE\n" +
            "    ,VIEW_COUNT\n" +
            "FROM BOARD B\n" +
            "JOIN EMPLOYEE E\n" +
            "ON B.EMP_NO = E.NO\n" +
            "WHERE B.TITLE LIKE '%'||#{title}||'%'")
    List<BoardVo> searchTitle(@Param("title") String title);

    @Select("SELECT BOARD_NO\n" +
            "    ,E.NAME\n" +
            "    ,B.TITLE\n" +
            "    ,B.CRTN_DATE\n" +
            "    ,VIEW_COUNT\n" +
            "FROM BOARD B\n" +
            "JOIN EMPLOYEE E\n" +
            "ON B.EMP_NO = E.NO\n" +
            "WHERE E.NAME LIKE '%'||#{empName}||'%'")
    List<BoardVo> searchEmpName(String empName);

    @Update("""
            UPDATE BOARD
            SET VIEW_COUNT = VIEW_COUNT +1
            WHERE BOARD_NO = #{no}
            """)
    void updateViewCount(int no);

    @Select("""
            SELECT B.*
                   ,E.NAME
            FROM BOARD B
            JOIN EMPLOYEE E
            ON B.EMP_NO = E.NO
            WHERE B.BOARD_NO = #{boardNo} AND B.EMP_NO = #{empNo}
            AND B.DEL_YN = 'N'
            """)
    BoardVo myListDetail(@Param("boardNo") String boardNo, @Param("empNo") String empNo);

    @Insert("""
        <script>
            INSERT INTO WISHLIST_BOARD (EMP_NO
            <if test="boardWishNo != null">
                , BOARD_WISH_NO
            </if>
            <if test="noticeWishNo != null">
                , NOTICE_WISH_NO
            </if>
            )
            VALUES (#{empNo}
            <if test="boardWishNo != null">
                , #{boardWishNo}
            </if>
            <if test="noticeWishNo != null">
                , #{noticeWishNo}
            </if>
            )
        </script>
    """)
    int wishBoard(WishBoardVo vo);

    @Delete("""
        DELETE
        FROM WISHLIST_BOARD
        WHERE BOARD_WISH_NO = #{boardWishNo}
        AND EMP_NO = #{empNo}
    """)
    int wishCanclaBoard(WishBoardVo vo );

    @Select("""
        SELECT COUNT(*) FROM 
        WISHLIST_BOARD WHERE EMP_NO = #{empNo} AND 
        BOARD_WISH_NO = #{boardWishNo}
    """)
    boolean checkWishList(WishBoardVo vo);

    @Select("""
            SELECT 
                W.EMP_NO,
                W.BOARD_WISH_NO,
                B.BOARD_NO,
                B.TITLE,
                B.CONTENT,
                B.VIEW_COUNT,
                B.CRTN_DATE,
                E.NAME
            FROM WISHLIST_BOARD W
            JOIN BOARD B
                ON W.BOARD_WISH_NO = B.BOARD_NO
            JOIN EMPLOYEE E
                ON W.EMP_NO = E.NO
            WHERE W.EMP_NO = #{empNo}
                AND (SELECT COUNT(*)
                     FROM WISHLIST_BOARD
                     WHERE EMP_NO = W.EMP_NO
                       AND BOARD_WISH_NO = W.BOARD_WISH_NO) > 0
            """)
    List<WishBoardVo> myWishList(WishBoardVo vo);

    @Insert("""
            INSERT INTO BOARD_COMMENT
            (COMT_NO
            ,BOARD_NO
            ,EMP_NO
            ,BOARD_COMMENT
            ,COMT_DATE
            )
            VALUES
            (SEQ_BOARD_COMMENT.NEXTVAL
            ,#{boardNo}
            ,#{vo.empNo}
            ,#{vo.boardComment}
            ,TO_CHAR(SYSTIMESTAMP, 'YYYY-MM-DD HH24:MI'))
            """)
    int commentWrite(@Param("vo") CommentVo vo, @Param("boardNo") String boardNo);

    @Select("""
            SELECT C.*
                   ,E.NAME
                   ,D.NAME AS depName
            FROM BOARD_COMMENT C
            JOIN EMPLOYEE E
            ON C.EMP_NO = E.NO
            JOIN BOARD B
            ON C.BOARD_NO = B.BOARD_NO
            JOIN DEPARTMENT D
            ON E.DEPT_NO = D.NO 
            WHERE C.BOARD_NO = #{boardNo}
            """)
    List<CommentVo> commentApi(String boardNo);

    @Delete("""
            DELETE 
            FROM  BOARD_COMMENT
            WHERE COMT_NO = #{comtNo}
            """)
    int commentDel(String comtNo);

//    @Select("""
//            SELECT SEQ_BOARD.CURRVAL FROM DUAL
//            """)
//    String getBoardByNo();
//
//    @Insert("""
//            INSERT INTO BOARD_IMG
//            (NO, BOARD_NO, IMG_NAME)
//            VALUES (SEQ_BOARD_IMG.NEXTVAL, #{boardNo}, #{imgName})
//            """)
//    int writeImg(BoardImgVo imgVo);
}
