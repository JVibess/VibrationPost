package com.vibratory.vibrationpost.post.services;

import com.vibratory.vibrationpost.post.exception.PostException;
import com.vibratory.vibrationpost.post.model.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    Post getById(Long id)throws PostException;

    Post updatePost(Long id, Post post)throws PostException;

    List<Post> getAllSongs();

    Boolean deletePost(Long id)throws PostException;

}
