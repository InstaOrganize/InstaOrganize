package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("boards")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO board) {
        boardService.create(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }

    @GetMapping
    List<BoardDTO> getAllBoards() {
        return boardService.getAll();
    }

    @GetMapping("/{id}")
    BoardDTO getBoard(@PathVariable String id) {
        return boardService.get(UUID.fromString(id));
    }

    @PutMapping
    public ResponseEntity<BoardDTO> updateBoard(@RequestBody BoardDTO board) {
        boardService.create(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }
}
