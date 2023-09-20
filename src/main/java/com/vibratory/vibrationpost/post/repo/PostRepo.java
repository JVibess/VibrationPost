package com.vibratory.vibrationpost.post.repo;

import com.vibratory.vibrationpost.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
