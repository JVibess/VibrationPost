package com.vibratory.vibrationpost.fan.services;

import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.fan.exception.FanException;
import com.vibratory.vibrationpost.fan.model.Fan;

import java.util.List;

public interface FanService {

    Fan create(Fan fan);

    Fan getById(Long id)throws FanException;

    Fan updateFan(Long id, Fan fan) throws FanException;

    Boolean deleteFan(Long id) throws FanException;

    List<Fan> getAllFans();

    List<Artist> getArtistFollowedByFan(Long artistId);




}
