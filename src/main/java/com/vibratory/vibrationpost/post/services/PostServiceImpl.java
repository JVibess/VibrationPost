package com.vibratory.vibrationpost.post.services;

import com.vibratory.vibrationpost.post.exception.PostException;
import com.vibratory.vibrationpost.post.model.Post;
import com.vibratory.vibrationpost.post.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements PostService{

    private PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo){this.postRepo=postRepo;}

    @Override
    public Post create(Post post) {
        Post savedPost = postRepo.save(post);
        return savedPost;
    }

    @Override
    public Post getById(Long id) throws PostException {
        Optional<Post> postOptional = postRepo.findById(id);
        if(postOptional.isEmpty()){
            throw new PostException("Post Not Found");
        }
        return postOptional.get();
    }

    @Override
    public Post updatePost(Long id, Post post) throws PostException {
        Optional<Post> postOptional = postRepo.findById(id);
        if(postOptional.isEmpty()){
            throw new PostException("post not found");
        }
        Post updatedPost = postOptional.get();
        updatedPost.setText(post.getText());
        return postRepo.save(updatedPost);
    }

    @Override
    public List<Post> getAllSongs() {
        return postRepo.findAll();
    }

    @Override
    public Boolean deletePost(Long id) throws PostException {
        Optional<Post> postOptional = postRepo.findById(id);
        if(postOptional.isEmpty()){
            throw new PostException("post does not exist");
        }
        Post postToDelete = postOptional.get();
        postRepo.delete(postToDelete);
        return true;
    }
}
