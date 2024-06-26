package com.kh.works.todo.dao;

import com.kh.works.todo.mapper.TodoMapper;
import com.kh.works.todo.vo.TodoVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoDao {
    private final TodoMapper mapper;

    public int todowrite(TodoVo todoVo) {
        return mapper.todoWrite(todoVo);
    }


    //상세조회
    public TodoVo getTodoByNo(String no) {
        return mapper.getTodoByNo(no);
    }


    //모든 할일 조회
    public List<TodoVo> getTodoListAll(TodoVo vo) {
        return mapper.getTodoListAll(vo);
    }

    //참여자인 할일 조회
    public List<TodoVo> getTodoListPar(String empNo) {
        return mapper.getTodoListPar(empNo);
    }


    //할일 수정
    public int todoEdit(TodoVo vo) {
        return mapper.todoEdit(vo);
    }


    //할일 검색
    public List<TodoVo> todoSearch(String title, String content) {
        return mapper.todoSearch(title, content);
    }

    //할일 삭제
    public int todoDelete(String todoNo) {
        return mapper.todoDelete(todoNo);
    }
}
