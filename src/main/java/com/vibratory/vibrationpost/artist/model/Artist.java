package com.vibratory.vibrationpost.artist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vibratory.vibrationpost.album.model.Album;
import com.vibratory.vibrationpost.common.Account;
import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.post.model.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Artist extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

    @ManyToMany
    private List<Fan> fans;

    @OneToMany
    @JoinColumn (name = "artist_album")
    private List<Album> albums;

    @OneToMany
    @JoinColumn(name = "artist_post")
    private List<Post> posts;

}
