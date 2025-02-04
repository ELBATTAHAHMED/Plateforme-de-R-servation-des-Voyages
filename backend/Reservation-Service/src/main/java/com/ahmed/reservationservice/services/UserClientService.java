/*package com.reservation.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
@Service

public class UserClientService {
	private final RestTemplate restTemplate;
    private final String userServiceBaseUrl = "http://localhost:8081/api/utilisateurs"; // L'URL de base du microservice utilisateur

    @Autowired
    public UserClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long userId) {
        String url = UriComponentsBuilder.fromHttpUrl(userServiceBaseUrl)
                                         .path("/" + userId)
                                         .toUriString();
        return restTemplate.getForObject(url, User.class);
    }
}*/
