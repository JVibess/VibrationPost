package com.vibratory.vibrationpost.post.model;

import com.vibratory.vibrationpost.comment.model.Comment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NonNull
    private String text;

    @NonNull
    private String mediaFile;

    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date dateCreated;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> commentList;
    @PrePersist
    protected void onCreate() {
        dateCreated = new Date(); // Set the creation date to the current date and time
    }

}
