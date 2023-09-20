package com.vibratory.vibrationpost.artist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vibratory.vibrationpost.common.Account;
import com.vibratory.vibrationpost.fan.model.Fan;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;
}
