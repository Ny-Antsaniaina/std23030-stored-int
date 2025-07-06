package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class StoredIntService {

    private static final String FILE_NAME = "stored-int.txt";

    public int getStoredInt() {
        File file = new File(FILE_NAME);
        try {
            if (file.exists()) {
                String content = Files.readString(Path.of(FILE_NAME));
                return Integer.parseInt(content.trim());
            } else {
                int randomInt = new Random().nextInt(100000);
                Files.writeString(Path.of(FILE_NAME), String.valueOf(randomInt));
                return randomInt;
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur d'accès au fichier", e);
        }
    }
}
