package com.vibratory.vibrationpost.artist.controller;

import com.vibratory.vibrationpost.artist.exception.ArtistException;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.artist.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private ArtistService artistService;


    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        Artist createdArtist = artistService.create(artist);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) throws ArtistException {
        Artist artist = artistService.getById(id);
        return new ResponseEntity<>(artist,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateById(@PathVariable Long id, @RequestBody Artist artist) throws ArtistException {
        artist = artistService.updateArtist(id,artist);
        return new ResponseEntity<>(artist,HttpStatus.ACCEPTED);
    }

}
