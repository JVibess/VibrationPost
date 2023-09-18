package com.vibratory.vibrationpost.comment.controller;


import com.vibratory.vibrationpost.comment.exception.CommentException;
import com.vibratory.vibrationpost.comment.model.Comment;
import com.vibratory.vibrationpost.comment.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){this.commentService=commentService;}

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment)throws CommentException{
        comment = commentService.create(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id)throws CommentException{
        Comment comment = commentService.getById(id);
        return new ResponseEntity(comment,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comment = commentService.getAllComments();
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }
}
