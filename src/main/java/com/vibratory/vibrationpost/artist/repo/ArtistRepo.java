package com.vibratory.vibrationpost.artist.repo;

import com.vibratory.vibrationpost.artist.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<Artist, Long> {

}
