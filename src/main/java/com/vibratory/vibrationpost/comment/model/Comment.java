package com.vibratory.vibrationpost.comment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NonNull
    private String text;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NonNull
    @Column(name = "post_id")
    private Long postId;

    @NonNull
    @Column(name = "fan_comment")
    private Long fanId;

    @NonNull
    @Column(name = "artist_comment")
    private Long artistId;



    @PrePersist
    protected void onCreate() {
        dateCreated = new Date(); // Set the creation date to the current date and time
    }
}
