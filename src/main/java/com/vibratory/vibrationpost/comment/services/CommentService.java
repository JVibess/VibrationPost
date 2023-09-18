package com.vibratory.vibrationpost.comment.services;

import com.vibratory.vibrationpost.comment.exception.CommentException;
import com.vibratory.vibrationpost.comment.model.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    Comment getById(Long id)throws CommentException;

    Comment updateComments(Long id, Comment comment)throws CommentException;

    List<Comment> getAllComments();

    Boolean deleteComments(Long id)throws CommentException;
}
