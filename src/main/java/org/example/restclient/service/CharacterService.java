package org.example.restclient.service;

import org.example.restclient.model.CharacterInfo;
import org.example.restclient.model.CharacterList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import org.example.restclient.model.Character;

@Service
public class CharacterService {

    private static final String BASE_URL = "https://rickandmortyapi.com/api";
    private static final String CHARACTER_ENDPOINT = "/character";
    private final RestClient restClient;

    public CharacterService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl(BASE_URL)
                .build();
    }

    public CharacterService() {
        this.restClient = null;
    }

    public List<Character> getAll() {
        return this.restClient.get()
                .uri(CHARACTER_ENDPOINT)
                .retrieve()
                .body(CharacterList.class).results();
    }

    public Character findById(String id) {
        String uri = CHARACTER_ENDPOINT + "/" + id;
        return this.restClient.get()
                .uri(uri)
                .retrieve()
                .body(Character.class);
    }

    public List<Character> findByStatus(String status) {
        String path = "?status=" + status;
        String uri = CHARACTER_ENDPOINT + path;
        return this.restClient.get()
                .uri(uri)
                .retrieve()
                .body(CharacterList.class).results();
    }

    public int findBySpecies(String species) {
        String path = "?species=" + species + "&status=Alive";
        String uri = CHARACTER_ENDPOINT + path;
        return this.restClient.get()
                .uri(uri)
                .retrieve()
                .body(CharacterList.class).info().count();

    }
}
