package com.vibratory.vibrationpost.fan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.common.Account;
import com.vibratory.vibrationpost.post.model.Post;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.stream.events.Comment;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Fan extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fanId;

    @NonNull
    private List<Fan> followingUser;

    @NonNull
    private List<Artist> followingArtist;

//    @NonNull
//    @OneToMany(mappedBy = "author")
//    private List<Comment> comments;
//
//    @NonNull
//    @OneToMany(mappedBy = "author")
//    private List<Post> posts;



}
