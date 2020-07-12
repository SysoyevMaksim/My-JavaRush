package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        while (fileReader.ready()) {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int c = fileReader.read();
                if (c == '\n' || c == -1) {
                    if (!stringBuilder.toString().equals("")) {
                        boolean a = false;
                        for (int i = 0; i < stringBuilder.length(); i++) {
                            if (Character.isDigit(stringBuilder.charAt(i))) {
                                a = true;
                            }
                        }
                        if (a) {
                            fileWriter.write(stringBuilder.toString() + " ");
                        }
                        break;
                    }
                }
                if (c == ' ') {
                    if (!stringBuilder.toString().equals("")) {
                        boolean a = false;
                        for (int i = 0; i < stringBuilder.length(); i++) {
                            if (Character.isDigit(stringBuilder.charAt(i))) {
                                a = true;
                            }
                        }
                        if (a) {
                            fileWriter.write(stringBuilder.toString() + " ");
                        }
                        break;
                    }
                }
                stringBuilder.append((char) c);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
