package com.artisan.solutions.gallery;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertThat;

@SpringBootTest
public class ArtistControllerTest {

    private static final String BASE_URL = "http://localhost:8888/artists";

    private RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void runBeforeAllTestMethods() {

    }

    @Test
    void returnsExistedArtist_whenGet_thenSuccess() {
        ResponseEntity<Artist> response = restTemplate.getForEntity(BASE_URL + 1, Artist.class);

        assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
    }

    @Test
    void whenPost_() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject personJsonObject = new JSONObject();

        personJsonObject.put("firstName", "Alx");
        personJsonObject.put("email", "am@mail.com");
        personJsonObject.put("password", "123");

        ResponseEntity<Artist> response = restTemplate.postForEntity(BASE_URL, headers, Artist.class);
        assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.CREATED));
    }
}

