package com.spring.client.board.repository;

import com.spring.client.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

//엔티티클래스명, ID 필드 형식
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);

    List<Board> findByTitleContaining(String title);
    List<Board> findByNameContaining(String name);
    List<Board> findByContentContaining(String content);

    List<Board> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Board> findByOrderByNoDesc();

    //JpaRepository
    Page<Board> findAll(Pageable pageable);
    Page<Board> findByTitleContaining(String keyword, Pageable pageable);

    @Query("SELECT b FROM Board b")
    public List<Board> boardList();

    //?다음에 위치 값을 지정하는 위치 기준 파라미터 사용
    @Query("SELECT b FROM Board b WHERE b.no = ?1")
    public Board boardDetail(Long no);

    @Query("SELECT b FROM Board b")
    public Page<Board> boardListPaging(Pageable pageable);

    @Query(value = "SELECT no, name, title, content, hit, reg_date FROM boot_board ORDER BY no DESC",nativeQuery = true)
    public List<Board> boardAllList();
}


