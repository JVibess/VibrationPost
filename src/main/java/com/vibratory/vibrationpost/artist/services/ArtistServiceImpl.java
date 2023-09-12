package com.vibratory.vibrationpost.artist.services;

import com.vibratory.vibrationpost.artist.exception.ArtistException;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.artist.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{

    private ArtistRepo artistRepo;

    @Autowired
    public ArtistServiceImpl(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }
    @Override
    public Artist create(Artist artist) {
        Artist savedArtist = artistRepo.save(artist);
        return savedArtist;
    }

    @Override
    public Artist getById(Long id) throws ArtistException {
        Optional<Artist> artistOptional = artistRepo.findById(id);
        if(artistOptional.isEmpty()){
            throw new ArtistException("Artist not found");
        }
        return artistOptional.get();
    }

    @Override
    public Artist updateArtist(Long id, Artist artist) throws ArtistException {
        Optional<Artist> artistOptional = artistRepo.findById(id);
        if(artistOptional.isEmpty()){
            throw new ArtistException("Artist not found");
        }
        Artist savedArtist = artistOptional.get();
        savedArtist.setBio(artist.getBio());
        savedArtist.setUserName(artist.getUserName());
        savedArtist.setImage(artist.getImage());
        savedArtist.setPassword(artist.getPassword());
        return artistRepo.save(savedArtist);
    }


}
