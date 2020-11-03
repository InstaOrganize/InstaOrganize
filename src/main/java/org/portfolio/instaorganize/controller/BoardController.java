package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.dto.TaskGroupDTO;
import org.portfolio.instaorganize.service.BoardService;
import org.portfolio.instaorganize.service.TaskGroupService;
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
    @Autowired
    private TaskGroupService taskGroupService;
    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO board) {
        return new ResponseEntity<>(boardService.create(board), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        return new ResponseEntity<>(boardService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable String id) {
        return new ResponseEntity<>(boardService.get(UUID.fromString(id)),HttpStatus.OK);
    }

    @GetMapping("{id}/task-groups")
    public ResponseEntity<List<TaskGroupDTO>> getTaskGroupsInBoard(@PathVariable String id) {
        return new ResponseEntity<>(taskGroupService.getTaskGroupsByBoardId(UUID.fromString(id)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BoardDTO> updateBoard(@RequestBody BoardDTO board) {
        boardService.create(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity deleteBoard(@RequestBody BoardDTO board) {
        boardService.delete(board);
        return new ResponseEntity(HttpStatus.OK);
    }
}
