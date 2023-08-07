package com.virtushawk.app.io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamApp {
    public static void main(String[] args) throws IOException {

        try (InputStream stream = InputStreamApp.class.getResourceAsStream("/test-read.txt")) {

            int character;

            do {
                character = stream.read();
                System.out.println(character);
            } while (character != -1);
        }
    }
}
