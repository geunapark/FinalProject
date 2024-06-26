package com.kh.works.employee.dao;

import com.kh.works.employee.mapper.EmpAccountMapper;
import com.kh.works.employee.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmpAccountDao {
    private final EmpAccountMapper mapper;


    public EmployeeVo empLoginMatching(EmployeeVo vo) {

        return mapper.empLoginMatching(vo);
    }

    public int empJoinDuplicateTest(String id) {
        return mapper.empJoinDuplicateTest(id);
    }

    public int join(EmployeeVo vo) {
       return mapper.join(vo);
    }
}
