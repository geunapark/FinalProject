package com.kh.works.admin.mapper;

import com.kh.works.admin.vo.AdminVo;
import com.kh.works.admin.vo.DeptVo;
import com.kh.works.admin.vo.PositionVo;
import com.kh.works.employee.vo.EmployeeVo;
import com.kh.works.security.AdminSessionVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {


    //신규사원 등록하는 페이지에서 옵션에 고를 수 있게 부서 조회해오기
    @Select("SELECT NO,NAME FROM DEPARTMENT")
    List<DeptVo> selectDeptList();

    @Insert("INSERT INTO EMPLOYEE (NO, EMAIL, NAME, DEPT_NO, POSITION_NO)VALUES(SEQ_EMPLOYEE.NEXTVAL, #{email},#{name}, #{deptNo}, #{positionNo})")
    void insertEmp(EmployeeVo employeeVo);

    @Select("SELECT ID,PWD,ADMIN_AUTHORITY_NO FROM ADMIN WHERE ID=#{id}")
    AdminSessionVo adminLoginIdMatching(String id);



//테스트
    String selectTest();

    @Select("SELECT NO,NAME\n" +
            "FROM POSITION")
    List<PositionVo> selectPosition();
}
