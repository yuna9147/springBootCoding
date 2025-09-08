package com.spring.mallapi.todo.repository;

import com.spring.mallapi.api.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
