package org.example.restclient.service;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static String read(Class<?> cls, String name) throws Exception {
        Path path = Paths.get(
                cls.getClassLoader().getResource(name).toURI()
        );

        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
