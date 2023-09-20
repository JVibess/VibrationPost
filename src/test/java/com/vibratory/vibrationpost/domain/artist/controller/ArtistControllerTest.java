package com.vibratory.vibrationpost.domain.artist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.vibratory.vibrationpost.artist.exception.ArtistException;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.artist.services.ArtistService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArtistControllerTest {

    @MockBean
    ArtistService mockArtistService;

    @Autowired
    private MockMvc mockMvc;

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
        mockResponseArtist1.setArtistId(id);
        mockResponseArtist1.setUserName(userName);
        mockResponseArtist1.setBio(bio);
        mockResponseArtist1.setImage(image);
        mockResponseArtist1.setPassword(password);

        mockResponseArtist2 = new Artist();
        mockResponseArtist2.setArtistId(2L);
        mockResponseArtist2.setUserName(userName);
        mockResponseArtist2.setBio(bio);
        mockResponseArtist2.setImage(image);
        mockResponseArtist2.setPassword(password);
    }

    @Test
    @DisplayName("Post: /artist artist created")
    public void createdArtistSuccess() throws Exception {
        JsonMapper jsonMapper = new JsonMapper();

        String jsonStringArtist = jsonMapper.writeValueAsString(artist);
        BDDMockito.doReturn(mockResponseArtist1).when(mockArtistService).create(any());

         mockMvc.perform(MockMvcRequestBuilders.post("/artist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStringArtist))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artistId", Is.is(1)));
    }

    @Test
    @DisplayName("Get all : /artist")
    public void getAllArtist(){
        List<Artist> mockArtist = new ArrayList<>();
        mockArtist.add(mockResponseArtist1);
        mockArtist.add(mockResponseArtist2);

        BDDMockito.when(mockArtistService.getAllArtist()).thenReturn(mockArtist);

        List<Artist> responseArts = mockArtistService.getAllArtist();

        Assertions.assertIterableEquals(mockArtist,responseArts);
    }

    @Test
    @DisplayName("Get By: /artist/id found")
    public void getByIdTestSuccess() throws Exception {
        BDDMockito.doReturn(mockResponseArtist1).when(mockArtistService).getById(id);

        mockMvc.perform(get("/artist/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artistId",Is.is(1)));
    }

    @Test
    @DisplayName("Delete By ID- Success")
    public void deleteByIdSuccess()throws Exception{
        BDDMockito.doReturn(true).when(mockArtistService).deleteArtist(any());

        mockMvc.perform(delete("/artist /{id}",id))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

}
