package com.kh.works.home.service;

import com.kh.works.board.vo.BoardVo;
import com.kh.works.employee.vo.EmployeeVo;
import com.kh.works.home.dao.HomeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeDao dao;
    public EmployeeVo selectEmpInfo(String no) {

        return dao.selectEmpInfo(no);
    }

    public int writing(BoardVo boardVo) {
        return dao.writing(boardVo);
    }
}