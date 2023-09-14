package com.vibratory.vibrationpost.domain.fan.services;

import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.fan.exception.FanException;
import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.fan.repo.FanRepository;
import com.vibratory.vibrationpost.fan.services.FanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FanServiceImplTest {

    @MockBean
    private FanRepository mockFanRepo;

    @Autowired
    private FanService fanService;

    private Fan fan;

    private Artist artist;

    private Fan mockResponseFan1;

    private Fan mockResponseFan2;

    private String userName;
    private String password;
    private String bio;

    private Long id;
    private String image;

    @BeforeEach
    public void setUp(){
        userName = "justinKan";
        password = "sumwords";
        bio = "a bio";
        image = "img.jpg";

        fan = new Fan();
        fan.setUserName(userName);
        fan.setImage(image);
        fan.setBio(bio);
        fan.setPassword(password);
        artist = new Artist();
        List<Artist> mockArtistList = new ArrayList<>();
        artist.setArtistId(1L);
        mockArtistList.add(artist);

        fan.setFollowingArtist(mockArtistList);

        mockResponseFan1 = new Fan();
        mockResponseFan1.setFanId(2L);
        mockResponseFan1.setUserName(userName);
        mockResponseFan1.setBio(bio);
        mockResponseFan1.setImage(image);
        mockResponseFan1.setPassword(password);

        mockResponseFan2 = new Fan();
        mockResponseFan2.setFanId(2L);
        mockResponseFan2.setUserName(userName);
        mockResponseFan2.setBio(bio);
        mockResponseFan2.setImage(image);
        mockResponseFan2.setPassword(password);

    }
    @Test
    @DisplayName("Fan Service: Create Fan Success")
    public void CreateFanTestSuccess(){
        BDDMockito.doReturn(mockResponseFan1).when(mockFanRepo).save(ArgumentMatchers.any());

        Fan returnFan = fanService.create(fan);

        Assertions.assertNotNull(returnFan,"Fan shouldnt be Null");
        Assertions.assertEquals(returnFan.getFanId(),2);

    }


    @Test
    @DisplayName("Fan Service: Get Fan By ID - Success")
    public void getFanByIdSuccess()throws FanException{
        BDDMockito.doReturn(Optional.of(mockResponseFan1)).when(mockFanRepo).findById(1L);

        Fan foundFanId = fanService.getById(1L);

        Assertions.assertEquals(mockResponseFan1.toString(), foundFanId.toString());
    }

    @Test
    @DisplayName("Fan Service: Get Fan By Id - Fail")
    public void getFanByIdFail(){
        BDDMockito.doReturn(Optional.empty()).when(mockFanRepo).findById(1L);
        Assertions.assertThrows(FanException.class, ()->fanService.getById(1L));

    }

    @Test
    @DisplayName("Fan Sercive: Get All Fans - Success")
    public void GetAllFansSuccess()throws FanException{
        List<Fan> fans = new ArrayList<>();

        fans.add(mockResponseFan1);
        fans.add(mockResponseFan2);

        BDDMockito.doReturn(fans).when(mockFanRepo).findAll();

        List<Fan> responseFans = fanService.getAllFans();

        Assertions.assertIterableEquals(fans,responseFans);
    }

    @Test
    @DisplayName("Fan Service: Delete Fan - Success")
    public void deleteFanSuccess()throws FanException{
        BDDMockito.doReturn(Optional.of(mockResponseFan1)).when(mockFanRepo).findById(1L);

        Boolean actualResponse = fanService.deleteFan(1L);

        Assertions.assertTrue(actualResponse);

    }

}
