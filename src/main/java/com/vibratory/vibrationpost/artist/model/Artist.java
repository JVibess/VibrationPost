package com.vibratory.vibrationpost.artist.model;

import com.vibratory.vibrationpost.common.Account;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@RequiredArgsConstructor
@EqualsAndHashCode
@Data
@ToString
@Getter
@Setter
public class Artist extends Account {

}
