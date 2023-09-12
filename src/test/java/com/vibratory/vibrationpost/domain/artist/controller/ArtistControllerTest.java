package com.vibratory.vibrationpost.domain.artist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.vibratory.vibrationpost.artist.model.Artist;
import com.vibratory.vibrationpost.artist.services.ArtistService;
import org.hamcrest.core.Is;
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

import static org.mockito.ArgumentMatchers.any;

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
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    }

}
