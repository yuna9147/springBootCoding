package com.spring.client.board.controller;

import com.spring.client.board.domain.Board;
import com.spring.client.board.service.BoardService;
import groovy.transform.stc.ClosureParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/board")
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping("/list")
    @ResponseBody
    public List<Board> list(Board board) {
        return boardService.boardList(board);
    }

}
