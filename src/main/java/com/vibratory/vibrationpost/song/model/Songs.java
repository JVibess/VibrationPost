package com.vibratory.vibrationpost.song.model;

import com.vibratory.vibrationpost.album.model.Album;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @NonNull
    private String name;

    @NonNull
    private String audioUrl;

    @NonNull
    @Column(name = "album_id")
    private Long albumId;


}
