package org.example.restclient.controller;

import lombok.AllArgsConstructor;
import org.example.restclient.model.RequestUser;
import org.example.restclient.model.ResponseUser;
import org.example.restclient.model.User;
import org.example.restclient.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public ResponseUser createUser(@RequestBody RequestUser user) {
        return userService.createUser(user);
    }

}
