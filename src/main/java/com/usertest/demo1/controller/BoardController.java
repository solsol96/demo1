package com.usertest.demo1.controller;

import com.usertest.demo1.model.dto.BoardVO;
import com.usertest.demo1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String boardList(Model model) {
        List<BoardVO> list = boardService.listAll();
        model.addAttribute("list" , list);
        return "boards/viewBoardList";
    }

    @GetMapping("/boards/new")
    public String createBoard() {
        return "boards/boardCreate";
    }

    @PostMapping("/boards/new")
    public String create(BoardVO vo) {
        BoardVO boardVO = new BoardVO();

        boardVO.setContent(vo.getContent());
        boardVO.setTitle(vo.getTitle());
        boardVO.setWriter(vo.getWriter());

        System.out.println(vo.getTitle());
        boardService.create(boardVO);

        return "redirect:/";
    }
}
