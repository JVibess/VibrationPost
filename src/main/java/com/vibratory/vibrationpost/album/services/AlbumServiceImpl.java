package com.vibratory.vibrationpost.album.services;

import com.vibratory.vibrationpost.album.exception.AlbumException;
import com.vibratory.vibrationpost.album.model.Album;
import com.vibratory.vibrationpost.album.repo.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{

    public AlbumRepo albumRepo;

    @Autowired
    public AlbumServiceImpl(AlbumRepo albumRepo){this.albumRepo = albumRepo;}


    @Override
    public Album create(Album album) throws AlbumException {
        Album savedAlbum = albumRepo.save(album);
        return savedAlbum;
    }

    @Override
    public Album getById(Long id) throws AlbumException {
        Optional<Album> albumOptional = albumRepo.findById(id);
        if(albumOptional.isEmpty()){
            throw new AlbumException("Album is not found");
        }
        return albumOptional.get();
    }

    @Override
    public List<Album> getAll() {
        return albumRepo.findAll();
    }

    @Override
    public Album updateAlbum(Long id, Album album) throws AlbumException {
        Album album1 = getById(id);
        album1.setName(album.getName());
        album1.setTracks(album.getTracks());
        album1.setArtistId(album.getArtistId());
        album1.setTracks(album.getTracks());
        return album1;

    }

    @Override
    public Boolean deleteAlbum(Long id) throws AlbumException {
        Optional<Album> albumOptional = albumRepo.findById(id);
        if(albumOptional.isEmpty()){
            throw new AlbumException("Album not found");
        }
        Album albumToDelete = albumOptional.get();
        albumRepo.delete(albumToDelete);
        return true;
    }
}
