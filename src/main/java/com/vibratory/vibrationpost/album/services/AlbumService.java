package com.vibratory.vibrationpost.album.services;

import com.vibratory.vibrationpost.album.exception.AlbumException;
import com.vibratory.vibrationpost.album.model.Album;

import java.util.List;

public interface AlbumService {

    Album create(Album album) throws AlbumException;

    Album getById(Long id) throws AlbumException;
    List<Album> getAll();

    Album updateAlbum(Long id, Album album) throws AlbumException;

    Boolean deleteAlbum(Long id) throws AlbumException;




}
