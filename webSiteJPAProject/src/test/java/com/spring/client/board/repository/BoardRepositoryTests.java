package com.spring.client.board.repository;

import com.spring.client.board.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

   // @Test
    public void boardInsertTest() {
        Board board = new Board();
        board.setName("하상욱");
        board.setTitle("지옥철");
        board.setContent("착하게 살았는데... 나는 왜 여기에");
        board.setRegDate(LocalDateTime.now());

        log.info("### board 테이블에 첫번째 데이터 입력");
        boardRepository.save(board);

        Board board1 = new Board();
        board1.setName("하상욱");
        board1.setTitle("다 쓴 치약");
        board1.setContent("끝이 어딜까..? 너의 잠재력");
        board1.setRegDate(LocalDateTime.now());

        log.info("### board 테이블에 두번째 데이터 입력");
        boardRepository.save(board1);

        Board board2 = new Board();
        board2.setName("하상욱");
        board2.setTitle("개인정보");
        board2.setContent("지켜 준다더니... 아껴 준다더니...");
        board2.setRegDate(LocalDateTime.now());

        log.info("### board 테이블에 세번째 데이터 입력");
        boardRepository.save(board2);

        Board board3 = new Board();
        board3.setName("하상욱");
        board3.setTitle("죽어라 이 모기 새끼야");
        board3.setContent("삶을 향한 너의 집념... 너를 향한 나의 박수!");
        board3.setRegDate(LocalDateTime.now());

        log.info("### board 테이블에 네번째 데이터 입력");
        boardRepository.save(board3);
    }

    //@Test
    public void boardCountTest() {
        long boardCount = boardRepository.count();
        log.info("레코드 수 : {} ",boardCount);
    }

    //@Test
    public void boardListTest() {
        List<Board> boardList = (List<Board>) boardRepository.findAll();
        boardList.forEach(board -> log.info(board.toString()));
    }

    //@Test
    public void boardDetailTest() {
        Optional<Board> boardOptional = boardRepository.findById(1L);

        if(boardOptional.isPresent()) {
            Board board = boardOptional.get();
            log.info("1번글의 데이터 : {}",board);
        }
    }

    //@Test
    public void boardUpdateTest() {
        Optional<Board> boardOptional = boardRepository.findById(6L);

        if(boardOptional.isPresent()) {
            Board board = boardOptional.get();
            board.setTitle("품절");
            board.setContent("소유할수 없기에... 포기할수 없는 너");

            log.info("### board 테이블에 데이터 수정");

            boardRepository.save(board);
        }
    }

   // @Test
    public void boardDeleteTest() {
        boardRepository.deleteById(6L);
    }

   // @Test
    public void findByTitleContainingTest() {
       // Board titleSearch = boardRepository.findByTitle("지옥철");
       // log.info(titleSearch.toString());


    //제목 검색
    //List<Board> list = boardRepository.findByTitleContaining("지옥철");

    //이름 검색
    //List<Board> list = boardRepository.findByNameContaining("하상욱");

    //내용 검색
    //List<Board> list = boardRepository.findByContentContaining("집념");

    //등록일 검색
    log.info(LocalDateTime.now().minusDays(3).toString());
    log.info(LocalDateTime.now().toString());
    List<Board> list = boardRepository.findByRegDateBetween(LocalDateTime.now().minusDays(3), LocalDateTime.now());
    list.forEach(board -> log.info(board.toString()));
    }

    //@Test
    public void findByOrderByNoDescTest() {

        List<Board> boardList = boardRepository.findByOrderByNoDesc();
        boardList.forEach(board -> log.info(board.toString()));
    }

    //@Test
    public void findAllByPageAndSort() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "no");
        Page<Board> result = boardRepository.findByTitleContaining("지옥철", pageable);
        result.forEach(board -> log.info(board.toString()));
    }

    @Test
    public void boardAllInsertTest() {
        for(int i=1; i<= 100; i++) {
            Board board = new Board();
            board.setTitle("Title..." + i);
            board.setName("홍길동" + i);
            board.setContent("실패한 자가 패배하는 것이 아니라 포기한 자가 패배하는 것이다.");
            boardRepository.save(board);

        }
    }

}


