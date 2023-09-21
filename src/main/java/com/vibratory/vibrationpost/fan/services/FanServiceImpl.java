package com.vibratory.vibrationpost.fan.services;

import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.fan.exception.FanException;
import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.fan.repo.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FanServiceImpl implements FanService{

    private FanRepository fanRepository;
    @Autowired
    public FanServiceImpl(FanRepository fanRepository){this.fanRepository=fanRepository;}
    @Override
    public Fan create(Fan fan) {
        Fan savedFan = fanRepository.save(fan);
        return savedFan;
    }

    @Override
    public Fan getById(Long id) throws FanException {
        Optional<Fan> fanOptional = fanRepository.findById(id);
        if(fanOptional.isEmpty()){
            throw new FanException("Fan not found" + id);
        }
        return fanOptional.get();
    }

    @Override
    public Fan updateFan(Long id, Fan fan) throws FanException {
       Optional<Fan> fanOptional = fanRepository.findById(id);
       if(fanOptional.isEmpty()){
           throw new FanException("Fan not found");
       }
       Fan updatedFan = fanOptional.get();
       updatedFan.setFollowingUser(fan.getFollowingUser());
       updatedFan.setBio(fan.getBio());
       updatedFan.setImage(fan.getImage());
       updatedFan.setFollowingArtist(fan.getFollowingArtist());
       updatedFan.setComments(fan.getComments());
       updatedFan.setPosts(fan.getPosts());
       return fanRepository.save(updatedFan);
    }

    @Override
    public Boolean deleteFan(Long id) throws FanException {
        Optional<Fan> fanOptional = fanRepository.findById(id);
        if(fanOptional.isEmpty()){
            throw new FanException("Fan does not exist, can not delete");
        }
        Fan fanToDelete = fanOptional.get();
        fanRepository.delete(fanToDelete);
        return true;
    }

    @Override
    public List<Fan> getAllFans() {
        return fanRepository.findAll();
    }

    @Override
    public List<Artist> getArtistFollowedByFan(Long artistId) {
        return null;
    }
}
