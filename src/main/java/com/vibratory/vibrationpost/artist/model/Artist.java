package com.vibratory.vibrationpost.artist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vibratory.vibrationpost.album.model.Album;
import com.vibratory.vibrationpost.comment.model.Comment;
import com.vibratory.vibrationpost.common.Account;
import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.post.model.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Artist extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

    @NonNull
    @ManyToMany(mappedBy = "followingArtists")
    private List<Fan> fans;

    @NonNull
    @OneToMany
    @JoinColumn (name = "artist_album")
    private List<Album> albums;

    @NonNull
    @OneToMany
    @JoinColumn(name = "artist_post")
    private List<Post> posts;

    @NonNull
    @OneToMany
    @JoinColumn(name = "artist_comment")
    private List<Comment> comments;

    @NonNull
    @Column(name = "followed_artist")
    private Long artist_followed;


}
