package com.artisan.solutions.gallery;

import com.artisan.solutions.gallery.persistence.model.Artist;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertThat;

@SpringBootTest
public class ArtistControllerTest {

    private static final String BASE_URL = "http://localhost:8888/";
    private static final String ARTISTS_PATH_VAR = "artists/";
    private static final String WORKS_PATH_VAR = "works/";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    void returnsExistedArtist_whenGet_thenSuccess() {
        ResponseEntity<Artist> response = restTemplate.getForEntity(BASE_URL + ARTISTS_PATH_VAR + 1, Artist.class);

        assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
    }

}
