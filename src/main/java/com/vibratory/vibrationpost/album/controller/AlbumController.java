package com.vibratory.vibrationpost.album.controller;

import com.vibratory.vibrationpost.album.exception.AlbumException;
import com.vibratory.vibrationpost.album.model.Album;
import com.vibratory.vibrationpost.album.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){this.albumService = albumService;}

    @PostMapping
    public ResponseEntity<Album> create(@RequestBody Album album) throws AlbumException {
        album = albumService.create(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> GetById(@PathVariable("id") Long id) throws AlbumException {
        Album album = albumService.getById(id);
        return new ResponseEntity<>(album,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("id")Long id, @RequestBody Album albumDetails) throws AlbumException {
        albumDetails = albumService.updateAlbum(id,albumDetails);
        return new ResponseEntity<>(albumDetails,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> delete(@PathVariable("id") Long id)throws AlbumException{
        albumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
