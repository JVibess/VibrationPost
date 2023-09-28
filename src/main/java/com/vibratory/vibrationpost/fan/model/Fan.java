package com.vibratory.vibrationpost.fan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.comment.model.Comment;
import com.vibratory.vibrationpost.common.Account;
import com.vibratory.vibrationpost.post.model.Post;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Fan extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fanId;

//    @NonNull
//    @ManyToMany
//    @JoinColumn
//    private List<Fan> followingUser;

    @NonNull
    @ManyToMany
    @JoinTable(name = "artist_fans",joinColumns = @JoinColumn(name ="name_id" ),
    inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> followingArtists;

    @NonNull
    @OneToMany
    @JoinColumn(name = "fan_comment")
    private List<Comment> comments;

    @NonNull
    @OneToMany
    @JoinColumn(name = "fan_post")
    private List<Post> posts;




}
