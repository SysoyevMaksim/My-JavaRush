package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
        words.add("Д");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        while (fileReader.ready()) {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int c = fileReader.read();
                if (c == -1) {
                    if (!stringBuilder.toString().equals("")) {
                        String s = stringBuilder.toString();
                        int i1 = 0, i2 = 0, count = 0;
                        while ((i2 = s.indexOf(' ', i2 + 1)) != -1){
                            String s1 = s.substring(i1, i2);
                            for (String s2 : words){
                                if (s1.equals(s2)) count++;
                            }
                            i1 = i2 + 1;
                        }
                        String s1 = s.substring(i1);
                        for (String s2 : words){
                            if (s1.equals(s2)) count++;
                        }
                        if (count == 2){
                            System.out.println(s);
                        }
                    }
                    break;
                }
                if (c == '\n' || c == '\r') {
                    if (!stringBuilder.toString().equals("")) {
                        String s = stringBuilder.toString();
                        int i1 = 0, i2 = 0, count = 0;
                        while ((i2 = s.indexOf(' ', i2 + 1)) != -1) {
                            String s1 = s.substring(i1, i2);
                            for (String s2 : words) {
                                if (s1.equals(s2)) count++;
                            }
                            i1 = i2 + 1;
                        }
                        String s1 = s.substring(i1);
                        for (String s2 : words){
                            if (s1.equals(s2)) count++;
                        }
                        if (count == 2){
                            System.out.println(s);
                        }
                    }
                    break;
                } else {
                    stringBuilder.append((char) c);
                }
            }
        }
        fileReader.close();
    }
}
