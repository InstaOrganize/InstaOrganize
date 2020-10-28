package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.model.Board;
import org.portfolio.instaorganize.repository.BoardRepository;
import org.portfolio.instaorganize.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("boards")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        boardService.create(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }

    @GetMapping
    List<Board> getAllBoards() {
        return boardService.getAll();
    }

    @GetMapping("/{id}")
    Board getBoard(@PathVariable String id) {
        return boardService.get(UUID.fromString(id));
    }
}
