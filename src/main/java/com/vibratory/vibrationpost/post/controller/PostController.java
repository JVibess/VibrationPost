package com.vibratory.vibrationpost.post.controller;

import com.vibratory.vibrationpost.post.exception.PostException;
import com.vibratory.vibrationpost.post.model.Post;
import com.vibratory.vibrationpost.post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService){this.postService = postService;}

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        post = postService.create(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id)throws PostException{
        Post post = postService.getById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updateById(@PathVariable("id") Long id, @RequestBody Post post)throws PostException{
        post = postService.updatePost(id,post);
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") Long id)throws PostException{
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
