package com.vibratory.vibrationpost.song.controller;

import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.song.exception.SongException;
import com.vibratory.vibrationpost.song.model.Songs;
import com.vibratory.vibrationpost.song.services.SongService;
import com.vibratory.vibrationpost.song.services.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService){this.songService = songService;}

    @PostMapping
    public ResponseEntity<Songs> create(@RequestBody Songs songs) {
        songs = songService.create(songs);
        return new ResponseEntity<>(songs, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Songs> getById(@PathVariable Long id) throws SongException{
        Songs songs = songService.getById(id);
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Songs> updateById(@PathVariable("id") Long id, @RequestBody Songs songs)throws SongException{
        songs = songService.udpateSong(id,songs);
        return new ResponseEntity<>(songs,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Songs> delete(@PathVariable("id") Long id)throws SongException{
        songService.deleteSongs(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
