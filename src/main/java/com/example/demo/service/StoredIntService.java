package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

@Service
public class StoredIntService {

    private static final String FILE_NAME = "/tmp/stored-int.txt";

    public int getStoredInt() {
        File file = new File(FILE_NAME);
        try {
            if (file.exists()) {
                String content = Files.readString(file.toPath());
                return Integer.parseInt(content.trim());
            } else {
                int randomNumber = new Random().nextInt(1000);
                FileWriter writer = new FileWriter(file);
                writer.write(String.valueOf(randomNumber));
                writer.close();
                return randomNumber;
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur de lecture/écriture du fichier", e);
        }
    }
}
