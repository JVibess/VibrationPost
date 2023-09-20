package com.vibratory.vibrationpost.common;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Account {

    @NonNull
    private String userName;

    @NonNull
    private String bio;

    @NonNull
    private String image;

    @NonNull
    private String password;
}
