package com.kh.works.board.controller;

//import com.kh.works.security.EmpSessionVo;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.kh.works.board.service.BoardService;
import com.kh.works.board.vo.BoardVo;
import com.kh.works.employee.vo.EmployeeVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService service;

    //게시물 작성하기 화면
    @GetMapping("write")
    public String wirte(){
        return "board/write";
    }

    //게시물 작성하기 백엔드
    @PostMapping("write")
    public String write(BoardVo vo, HttpSession session){

        //추가했어요 !!!!
        EmployeeVo loginEmpVo = (EmployeeVo)session.getAttribute("loginEmpVo");

        //추가했어요!!!!
        String empNo = loginEmpVo.getNo();
        //String empNo = loginEmployeeVo.getNo();
        vo.setEmpNo(empNo);
        int result = service.write(vo);
        if (result != 1){
            return "common/error";
        }
        return "redirect:/board/list";
     }

     //게시물 리스트 화면
     @GetMapping("list")
    public String showBoardList(){
        return "board/list";
     }

     //게시물 데이터
    @GetMapping("api/list")
    @ResponseBody
    public List<BoardVo> getBoardList(){
        return service.getBoardList();
    }
    
    //내 게시물 화면
    @GetMapping("mylist")
    public String getMyList(){
        return "board/mylist";
    }

    //내 게시물 데이터
    @GetMapping("api/mylist")
    @ResponseBody
    public List<BoardVo> myBoardList(HttpSession session){

        //추가했어요 !!!!
        EmployeeVo loginEmpVo = (EmployeeVo)session.getAttribute("loginEmpVo");

        String empNo = loginEmpVo.getNo();
        return service.myBoardList(empNo);
    }

//    게시물 상세조회 화면
    @GetMapping("/detail")
    public String getdetailBoard(@RequestParam("boardNo")String boardNo ,Model model , HttpSession session) {

        //추가했어요 !!!!
        EmployeeVo loginEmpVo = (EmployeeVo)session.getAttribute("loginEmpVo");

        String loginNo = loginEmpVo.getNo();
        System.out.println("현재 로그인한 사람의 넘버: " + loginNo);
        model.addAttribute("empNo", loginNo);
        return "board/detail";
    }

    @GetMapping("api/detail")
    @ResponseBody
    public BoardVo apiDetailBoard(@RequestParam("boardNo")String boardNo ,Model model , HttpSession session){
        BoardVo vo = service.getBoardDetail(boardNo);
        System.out.println("Controller Vo" + vo);
        model.addAttribute("boardNo" , boardNo);
        model.addAttribute("board" , vo);
        return vo;
    }

    //수정하기 화면 보여주기
    @GetMapping("edit")
    public String editView(){
        return "board/edit";
    }


    @PostMapping("edit")
    public String editBoard(BoardVo vo, @RequestParam("boardNo")String boardNo){

        System.out.println(vo + boardNo);
        int result = service.editBoard(vo , boardNo);

        if(result != 1){
            return "common/error";
        }
        return "redirect:/board/list";
    }

    //삭제하기
    @GetMapping("delete")
    public String deleteBoard(@RequestParam("boardNo") String boardNo){

        int result = service.deleteBoard(boardNo);

        if (result != 1){
            return "common/error";
        }
        return "redirect:/board/list";
    }

}
