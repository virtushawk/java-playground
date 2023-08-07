package com.virtushawk.app.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamApp {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\test.txt");

        file.createNewFile();

        if (!file.exists()) {
            System.out.println("File doesn't exit!");
            return;
        }

        try (OutputStream outputStream = new FileOutputStream(file)) {
            String hello = new String("hello");

            outputStream.write(hello.getBytes());
        }
    }
}
