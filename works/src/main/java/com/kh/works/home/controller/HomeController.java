package com.kh.works.home.controller;

import com.kh.works.attend.vo.AttendVo;
import com.kh.works.board.vo.BoardVo;
import com.kh.works.employee.vo.EmployeeVo;
import com.kh.works.home.service.HomeService;
import com.kh.works.messenger.vo.MessengerVo;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
//로그인하면 넘어가는 홈 페이지 경로 때문에 아래와 같이 작성하였습니다.
@RequestMapping("/home")
public class HomeController {

    //*****************HomeController에는 근태관리를 위한 출퇴근 메소드가 있습니다*****************

    private final HomeService service;

    //홈화면 보여주기 - session 불러와서 처리
    @GetMapping
    public String home(HttpSession session, Model model) {

        EmployeeVo loginEmpVo = (EmployeeVo) session.getAttribute("loginEmpVo");

        String empNo = loginEmpVo.getNo();
        System.out.println("empNo = " + empNo);

        //********이렇게 다른 테이블Vo 받아오면 된다.이렇게 하면 jsp에서 사용하기 가능.
        AttendVo attendVo = service.getAttendInfo(empNo);

        model.addAttribute("loginEmpVo", loginEmpVo);
        model.addAttribute("attendVo", attendVo);

        return "home/home";
    }
    //출근 찍기 - insert 구문을 사용해야 한다.
    @PostMapping("start")
    public String start(AttendVo vo, HttpSession session){

        EmployeeVo loginEmpVo = (EmployeeVo)session.getAttribute("loginEmpVo");

        String empNo = loginEmpVo.getNo();
        System.out.println("empNo = " + empNo);
        vo.setEmpNo(empNo);

        //alreadyStart() - 출근버튼을 찍었는데 퇴근버튼을 찍지 않았으면 출근버튼 다시 찍지 못하도록 막는 메서드
        if(service.alreadyStart(vo.getEmpNo()) || service.alreadyAttend(vo.getEmpNo())){
            return "redirect:/home";
        }

        int result = service.start(vo);
        if(result != 1){
            return "common/error";
        }
        return "redirect:/home";

    }
    //퇴근 찍기 - update 구문을 사용해야 한다.
    @PostMapping("end")
    public String end(AttendVo vo, HttpSession session){

        EmployeeVo loginEmpVo = (EmployeeVo) session.getAttribute("loginEmpVo");

        String empNo = loginEmpVo.getNo();
        System.out.println("empNo = " + empNo);
        vo.setEmpNo(empNo);

        int result = service.end(vo);
        if(result != 1){
            return "common/error";
        }
        return "redirect:/home";
    }







    //*** 수인언니가 작성한 친절한 예시 참고 ***
//
//    //내정보 보여주기
//    @GetMapping("emp/info")
//    @ResponseBody
//    public EmployeeVo selectEmpInfo(HttpSession session) {
//        //세션에서 로그인한 사원객체꺼내기
//        EmployeeVo loginEmpVo = (EmployeeVo) session.getAttribute("loginEmpVo");
//        //세션에서 원하는 정보꺼내기
//        String no = loginEmpVo.getNo();
//        String name = loginEmpVo.getName();
//
//        System.out.println("name?은?" + name);
//        return service.selectEmpInfo(no);      //직원번호에 해당하는 이름,아이디를 가져옴
//    }
//
//    //게시판에 글적기 샘플용
//    @PostMapping("writing")
//    public String writing(HttpSession session, BoardVo boardVo) {
//        EmployeeVo loginEmpVo = (EmployeeVo) session.getAttribute("loginEmpVo");
//
//        String no = loginEmpVo.getNo();
//
//        boardVo.setEmpNo(no);
//        int result = service.writing(boardVo);
//        if (result != 1) {
//            return "common/error";
//        }
//        return "redirect:home/home";
//    }
}



