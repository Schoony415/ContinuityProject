package com.cp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static String readFileAsString(String fileName) {
        String text = "File grabber didn't work!";
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    //Read more: https://www.java67.com/2016/08/how-to-read-text-file-as-string-in-java.html#ixzz6nDwSkUVT
}
