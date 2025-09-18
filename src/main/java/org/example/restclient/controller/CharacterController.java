package org.example.restclient.controller;

import lombok.AllArgsConstructor;
import org.example.restclient.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.example.restclient.model.Character;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/characters")
    public List<Character> getCharacters(@RequestParam(required = false) String status) {
        if(status == null) {
            return characterService.getAll();
        }
        return characterService.findByStatus(status);
    }

    @GetMapping("/characters/{id}")
    public Character getCharacter(@PathVariable String id) {
        return characterService.findById(id);
    }

    @GetMapping("/species-statistic")
    public int getSpeciesStatistic(@RequestParam String species) {
        return characterService.findBySpecies(species);
    }
}
