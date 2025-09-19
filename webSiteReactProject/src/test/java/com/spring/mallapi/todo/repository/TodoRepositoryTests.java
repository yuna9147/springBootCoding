package com.spring.mallapi.todo.repository;

import com.spring.mallapi.api.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {
    @Autowired
    private TodoRepository todoRepository;


    @Test
    public void testInsert() {
        for(int i= 1; i<=100; i++) {
            Todo todo = Todo.builder()
                    .title("Title...." + i)
                    .dueDate(LocalDate.of(2025,9,8))
                    .writer("user"+i).build();
            todoRepository.save(todo);
        }
    }

    @Test
    public void testInsert2() {
        for(int i= 101; i<=104; i++) {
            Todo todo = Todo.builder()
                    .title("Title...." + i)
                    .dueDate(LocalDate.of(2025,9,17))
                    .writer("user"+i).build();
            todoRepository.save(todo);
        }
    }

    //데이터 수정
    @Test
    public void testRead() {
        Long tno = 33L;
        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();
        todo.changeTitle("Modified 33...");
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2025,9,10));

        Todo todoResult = todoRepository.save(todo);
        log.info("수정된 (33L)데이터 ; {}", todoResult);
    }

    //데이터 삭제
    @Test
    public void testDelete() {
        Long tno = 11L;

        todoRepository.deleteById(tno);
    }

    //페이징 처리
    @Test
    public void testPaging(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("tno").descending());
        Page<Todo> result = todoRepository.findAll(pageable);
        log.info("총 데이터 수 : {}", result.getTotalElements());
        result.getContent().stream().forEach(todo -> log.info(todo.toString()));
    }
}
