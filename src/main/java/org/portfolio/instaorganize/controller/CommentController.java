package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.dto.CommentDTO;
import org.portfolio.instaorganize.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment) {
        commentService.create(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComment() {
        return new ResponseEntity<>(commentService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable String id) {
        return new ResponseEntity<>(commentService.get(UUID.fromString(id)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO comment) {
        commentService.create(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteComment(@RequestBody CommentDTO comment) {
        commentService.delete(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
