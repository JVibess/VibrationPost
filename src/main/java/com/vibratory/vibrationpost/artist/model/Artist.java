package com.vibratory.vibrationpost.artist.model;

import com.vibratory.vibrationpost.common.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@RequiredArgsConstructor
@EqualsAndHashCode
@Data
@ToString
@Getter
@Setter
public class Artist extends Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;


}
