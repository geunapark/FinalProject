package com.kh.works.notice.mapper;

import com.kh.works.notice.vo.NoticeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Insert("INSERT INTO NOTICE_BOARD\n" +
            "(\n" +
            "    NOTICE_NO\n" +
            "    ,NO\n" +
            "    ,TITLE\n" +
            "    ,CONTENT\n" +
            "    ,VIEW_COUNT\n" +
            "    ,CRTN_DATE\n" +
            "    ,MDFD_DATE\n" +
            "    ,IMG\n" +
            ")VALUES\n" +
            "(\n" +
            "    SEQ_NOTICE_BOARD.NEXTVAL\n" +
            "    ,#{no}\n" +
            "    ,#{title}\n" +
            "    ,#{content}\n" +
            "    ,NULL\n" +
            "    ,SYSTIMESTAMP\n" +
            "    ,NULL\n" +
            "    ,NULL\n" +
            ")")
    int write(NoticeVo vo);


    @Select("SELECT *\n" +
            "FROM NOTICE_BOARD \n" +
            "WHERE DEL_YN = 'N'")
    List<NoticeVo> list();


    @Select("SELECT * FROM NOTICE_BOARD WHERE NOTICE_NO = #{noticeNo}")
    NoticeVo detail(String noticeNo);

    @Update("UPDATE NOTICE_BOARD SET DEL_YN = 'Y' WHERE NOTICE_NO =#{noticeNo}")
    int delete(String noticeNo);
}
