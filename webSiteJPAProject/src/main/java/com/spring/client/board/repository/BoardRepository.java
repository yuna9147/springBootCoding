package com.spring.client.board.repository;

import com.spring.client.board.domain.Board;
import org.springframework.data.repository.CrudRepository;
                                                //엔티티클래스명, ID 필드 형식
public interface BoardRepository extends CrudRepository<Board, Long> {
}
