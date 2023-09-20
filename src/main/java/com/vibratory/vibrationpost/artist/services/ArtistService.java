package com.vibratory.vibrationpost.artist.services;

import com.vibratory.vibrationpost.artist.exception.ArtistException;
import com.vibratory.vibrationpost.artist.model.Artist;

public interface ArtistService {
    Artist create(Artist artist);


    Artist getById(Long id)throws ArtistException;

    Artist updateArtist(Long id, Artist artist)throws ArtistException;
}
