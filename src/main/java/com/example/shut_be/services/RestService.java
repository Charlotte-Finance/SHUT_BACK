package com.example.shut_be.services;

import com.example.shut_be.domains.Post;
import com.example.shut_be.domains.Preference;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestService {
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Post[] getPostsAsObject() {
        String url = "https://192.168.179.132/update";
        return this.restTemplate.getForObject(url, Post[].class);
    }

    public String getPostsPlainJSON() {
        String url = "https://192.168.179.132/update";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Post getPostWithUrlParameters() {
        String url = "https://192.168.179.132/update/{id}";
        return this.restTemplate.getForObject(url, Post.class, 1);
    }

    public Post getPostWithResponseHandling() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public Post sendUpdate(Preference preference){
        String url = "http://192.168.179.132/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("max_sound", preference.getMaxSound());
        map.put("max_vibration", preference.getMaxVibration());
        map.put("music", preference.getMusic());
        map.put("sound_alert", preference.getSoundAlert());
        map.put("color_alert", preference.getColorAlert());
        map.put("sound_control", preference.getSoundControl());
        map.put("user_id", preference.getUserId());

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        // send POST request
        ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
