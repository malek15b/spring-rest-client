package org.example.restclient.service;

import org.example.restclient.model.RequestUser;
import org.example.restclient.model.ResponseUser;
import org.example.restclient.model.User;
import org.example.restclient.model.UserList;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class UserService {

    private static final String API_KEY = "reqres-free-v1";
    private static final String BASE_URL = "https://reqres.in/api";
    private static final String CHARACTER_ENDPOINT = "/users";
    private final RestClient restClient;

    public UserService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl(BASE_URL)
                .build();
    }

    public List<User> getAll() {
        return this.restClient.get()
                .uri(CHARACTER_ENDPOINT)
                .retrieve()
                .body(UserList.class).data();
    }

    public ResponseUser createUser(RequestUser user) {
        return this.restClient.post()
                .uri(CHARACTER_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-api-key", API_KEY)
                .body(user)
                .retrieve()
                .body(ResponseUser.class);
    }

    public List<User> getAllList() {
        User[] users = this.restClient.get()
                .uri(CHARACTER_ENDPOINT)
                .retrieve()
                .body(User[].class);
        return List.of(users);
    }
}
