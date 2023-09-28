package com.vibratory.vibrationpost.song.services;

import com.vibratory.vibrationpost.song.exception.SongException;
import com.vibratory.vibrationpost.song.model.Songs;
import com.vibratory.vibrationpost.song.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{

    private SongRepo songRepo;


    @Autowired
    public SongServiceImpl(SongRepo songRepo){this.songRepo=songRepo;}


    @Override
    public Songs create(Songs songs) {
        Songs savedSongs = songRepo.save(songs);

        return savedSongs;
    }

    @Override
    public Songs getById(Long id) throws SongException {
        Optional<Songs> songsOptional = songRepo.findById(id);
        if(songsOptional.isEmpty()){
            throw new SongException("Song Not Found");
        }
        return songsOptional.get();
    }

    @Override
    public Songs udpateSong(Long id, Songs songs) throws SongException {
        Optional<Songs> songsOptional = songRepo.findById(id);
        if(songsOptional.isEmpty()){
            throw new SongException("song is not found");
        }
        Songs updatedSongs = songsOptional.get();
        updatedSongs.setAlbumId(songs.getAlbumId());
        updatedSongs.setName(songs.getName());
        updatedSongs.setAudioUrl(songs.getAudioUrl());
        return songRepo.save(updatedSongs);
    }

    @Override
    public List<Songs> getAllSongs() {
        return songRepo.findAll();
    }

    @Override
    public Boolean deleteSongs(Long id) throws SongException {
        Optional<Songs> songsOptional =songRepo.findById(id);

        if(songsOptional.isEmpty()){
            throw new SongException("Songs does not exist");
        }
        Songs songToDelete = songsOptional.get();
        songRepo.delete(songToDelete);
        return true;
    }
}
