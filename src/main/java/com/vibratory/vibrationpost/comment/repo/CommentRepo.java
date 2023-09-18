package com.vibratory.vibrationpost.comment.repo;

import com.vibratory.vibrationpost.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
