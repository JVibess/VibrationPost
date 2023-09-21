package com.vibratory.vibrationpost.album.model;

import com.vibratory.vibrationpost.song.model.Songs;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String Name;

    @OneToMany
    @JoinColumn(name = "album_id")
    private List<Songs> tracks;

    @NonNull
    @Column(name = "artist_album")
    private Long artistId;
}
