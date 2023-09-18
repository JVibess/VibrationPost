package com.vibratory.vibrationpost.song.services;

import com.vibratory.vibrationpost.song.exception.SongException;
import com.vibratory.vibrationpost.song.model.Songs;

import java.util.List;

public interface SongService {

    Songs create(Songs songs);

    Songs getById(Long id)throws SongException;

    Songs udpateSong(Long id, Songs songs) throws SongException;

    List<Songs> getAllSongs();

    Boolean deleteSongs(Long id)throws SongException;
}
