package com.vibratory.vibrationpost.domain.artist.services;

import com.vibratory.vibrationpost.artist.exception.ArtistException;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.artist.repo.ArtistRepo;
import com.vibratory.vibrationpost.artist.services.ArtistService;
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

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ArtistServiceImplTest {

    @MockBean
    private ArtistRepo mockArtistRepo;
    @Autowired
    private ArtistService artistService;
    private Artist artist;
    private Artist mockResponseArtist1;
    private Artist mockResponseArtist2;


    private String userName;
    private String password;
    private String bio;

    private Long id;
    private String image;

    @BeforeEach
    public void setUp(){
        userName = "burnaBoy";
        bio = "a bio";
        password = "password";
        image = "img.jpg";
        id = 1L;
        artist = new Artist();
        artist.setUserName(userName);
        artist.setBio(bio);
        artist.setImage(image);
        artist.setPassword(password);

        mockResponseArtist1 = new Artist();
        mockResponseArtist1.setId(id);
        mockResponseArtist1.setUserName(userName);
        mockResponseArtist1.setBio(bio);
        mockResponseArtist1.setImage(image);
        mockResponseArtist1.setPassword(password);

        mockResponseArtist2 = new Artist();
        mockResponseArtist2.setId(2L);
        mockResponseArtist2.setUserName(userName);
        mockResponseArtist2.setBio(bio);
        mockResponseArtist2.setImage(image);
        mockResponseArtist2.setPassword(password);
    }

    @Test
    @DisplayName("Artist Service: Create Artist-Success")
    public void createArtistTestSuccess(){
        BDDMockito.doReturn(mockResponseArtist1).when(mockArtistRepo).save(ArgumentMatchers.any());

        Artist returnArtist = artistService.create(artist);

        Assertions.assertNotNull(returnArtist,"artist should not be null");
        Assertions.assertEquals(returnArtist.getId(),1L);
    }

    @Test
    @DisplayName("Artist Service: Get Artist By ID - Success")
    public void getArtistByIdSuccess() throws ArtistException{
        BDDMockito.doReturn(Optional.of(mockResponseArtist1)).when(mockArtistRepo).findById(id);
        Artist foundArtistId = artistService.getById(id);

        Assertions.assertEquals(mockResponseArtist1.toString(),foundArtistId.toString());
    }

    @Test
    @DisplayName("Artist Service: Update Artist By Id")
    public void UpdateArtustById() throws ArtistException{
        Artist expectedArtistUpdate = mockResponseArtist2;

        BDDMockito.doReturn(Optional.of(mockResponseArtist1)).when(mockArtistRepo).findById(id);

        BDDMockito.doReturn(expectedArtistUpdate).when(mockArtistRepo).save(ArgumentMatchers.any());

        Artist acutalArtist = artistService.updateArtist(1L,artist);

        Assertions.assertEquals(expectedArtistUpdate.toString(),acutalArtist.toString());
    }
}
