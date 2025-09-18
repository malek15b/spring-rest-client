package org.example.restclient.model;

public record ResponseUser(String id,
                           String name,
                           String job,
                           String createdAt) {
}
