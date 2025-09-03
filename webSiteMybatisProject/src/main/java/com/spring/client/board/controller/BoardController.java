package com.spring.client.board.controller;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.Board;
import com.spring.common.dto.RequestDTO;
import com.spring.common.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

//    @GetMapping("/boardList")
//    public String boardLIst(@ModelAttribute Board board, Model model) {
//        List<Board> boardList = boardService.boardList(board);
//        model.addAttribute("boardList",boardList);
//        return "client/board/boardList";
//    }

    @GetMapping("/boardList")
    public String boardList(Board board, RequestDTO requestDTO, Model model) {
        ResponseDTO<Board> boardList = boardService.list(requestDTO);
        model.addAttribute("boardList", boardList);
        return "client/board/boardList";
    }

    @GetMapping("/insertForm")
    public String insertForm(Board board){
        return "client/board/insertForm";
    }

    @PostMapping("/boardInsert")
    public String boardInsert(Board board){
        boardService.boardInsert(board);
        return "redirect:/board/boardList";
    }

    @GetMapping("/{boardNumber}")
    public String boardDetail(@PathVariable int boardNumber, Model model) {
        Board detail = boardService.boardDetail(boardNumber);
        model.addAttribute("detail", detail);
        return "client/board/boardDetail";
    }

    @GetMapping(value="/updateForm")
    public String updateForm(@ModelAttribute Board board, Model model) {
        Board updateData = boardService.updateForm(board.getBoardNumber());
        model.addAttribute("updateData", updateData);
        return "client/board/updateForm";
    }

    @PostMapping("/boardUpdate")
    public String boardUpdate(@ModelAttribute Board board)  {
        boardService.boardUpdate(board);
        return "redirect:/board/"+board.getBoardNumber();
    }

    @PostMapping(value="/boardDelete")
    public String boardDelete(@ModelAttribute Board board) {
        boardService.boardDelete((board.getBoardNumber()));
        return "redirect:/board/boardList";
    }

    @ResponseBody
    @PostMapping(value="/pwdConfirm",produces = "text/plain; charset=UTF-8")
    public String pwdConfirm(Board board) {
        int result = boardService.pwdConfirm(board);
        return (result ==1 ) ? "일치" :"불일치";
    }
}


