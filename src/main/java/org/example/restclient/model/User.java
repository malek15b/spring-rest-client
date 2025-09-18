package org.example.restclient.model;

public record User(String id,
                   String email,
                   String first_name,
                   String last_name,
                   String avatar) {
}
