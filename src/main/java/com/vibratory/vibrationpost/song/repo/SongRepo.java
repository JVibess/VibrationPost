package com.vibratory.vibrationpost.song.repo;

import com.vibratory.vibrationpost.song.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Songs,Long> {
}
