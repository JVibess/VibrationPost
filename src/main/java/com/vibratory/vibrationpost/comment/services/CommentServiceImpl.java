package com.vibratory.vibrationpost.comment.services;

import com.vibratory.vibrationpost.comment.exception.CommentException;
import com.vibratory.vibrationpost.comment.model.Comment;
import com.vibratory.vibrationpost.comment.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo){this.commentRepo = commentRepo;}
    @Override
    public Comment create(Comment comment) {
        Comment savedComment = commentRepo.save(comment);
        return savedComment;
    }

    @Override
    public Comment getById(Long id) throws CommentException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()){
            throw new CommentException("comment not found " + id);
        }
        return commentOptional.get();
    }

    @Override
    public Comment updateComments(Long id, Comment comment) throws CommentException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()){
            throw new CommentException("comment not found");
        }
        Comment updatedComment = commentOptional.get();
        updatedComment.setText(comment.getText());
        updatedComment.setArtistId(comment.getCommentId());
        updatedComment.setFanId(comment.getFanId());
        updatedComment.setDateCreated(comment.getDateCreated());
        updatedComment.setPostId(comment.getPostId());
        return commentRepo.save(updatedComment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Boolean deleteComments(Long id) throws CommentException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()){
            throw new CommentException("comment does not exist");
        }
        Comment commentToDelete = commentOptional.get();
        commentRepo.delete(commentToDelete);
        return true;
    }
}
