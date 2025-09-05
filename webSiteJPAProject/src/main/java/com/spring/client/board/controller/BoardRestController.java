package com.spring.client.board.controller;

import com.spring.client.board.domain.Board;
import com.spring.client.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping("/list")
    @ResponseBody
    public List<Board> list(Board board) {
        return boardService.boardList(board);
    }

}
