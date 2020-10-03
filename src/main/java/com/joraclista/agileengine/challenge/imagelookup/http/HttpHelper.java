package com.joraclista.agileengine.challenge.imagelookup.http;

import com.joraclista.agileengine.challenge.imagelookup.model.Auth;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Created by Alisa
 * version 1.0.
 */
public interface HttpHelper {

    int CONNECTION_TIMEOUT_MS = 2000;
    int READ_TIMEOUT_MS = 2000;

    static <T> HttpEntity<T> getBasicRequestWithBody(T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

    static HttpEntity getBasicAuthRequest(Auth auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization", "Bearer " + auth.getToken());
        return new HttpEntity<>(headers);
    }

    static RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(CONNECTION_TIMEOUT_MS))
                .setReadTimeout(Duration.ofMillis(READ_TIMEOUT_MS))
                .build();
    }

}
