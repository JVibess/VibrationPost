package com.vibratory.vibrationpost.album.repo;

import com.vibratory.vibrationpost.album.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<Album,Long> {
}
