package com.joraclista.agileengine.challenge.imagelookup.http;

import com.joraclista.agileengine.challenge.imagelookup.model.Auth;
import com.joraclista.agileengine.challenge.imagelookup.model.Image;
import com.joraclista.agileengine.challenge.imagelookup.model.PageOfImages;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Created by Alisa
 * version 1.0.
 */
@Slf4j
@AllArgsConstructor
public class ImagesHttpClient {
    private static final int CONNECTION_TIMEOUT_MS = 2000;
    private static final int READ_TIMEOUT_MS = 2000;
    private Auth auth;
    private String url;

    private HttpEntity getBasicAuthRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization", "Bearer " + auth.getToken());
        return new HttpEntity<>(headers);
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(CONNECTION_TIMEOUT_MS))
                .setReadTimeout(Duration.ofMillis(READ_TIMEOUT_MS))
                .build();
    }

    public PageOfImages getNextPage(Auth auth, int pageNumber) {
        log.info("getNextPage: id=" + pageNumber);
        ResponseEntity<PageOfImages> pageResponse = getRestTemplate().exchange(url + "/images?page=" + pageNumber,
                HttpMethod.GET,
                getBasicAuthRequest(),
                PageOfImages.class);
        return pageResponse.getBody();

    }

    public Image getImageInfo(Auth auth, String imageID) {
        log.info("getImageInfo: id=" + imageID);

        ResponseEntity<Image> pageResponse = getRestTemplate().exchange(url + "/images/" + imageID,
                HttpMethod.GET,
                getBasicAuthRequest(),
                Image.class);
        return pageResponse.getBody();

    }

}
