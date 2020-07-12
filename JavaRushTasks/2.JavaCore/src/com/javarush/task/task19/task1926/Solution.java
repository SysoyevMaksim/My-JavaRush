package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();
        main_change(stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void main_change(StringBuilder stringBuilder){
        for (String s : stringBuilder.toString().split("\n")){
            StringBuilder stringBuilder1 = new StringBuilder(s);
            stringBuilder1.reverse();
            stringBuilder.replace(stringBuilder.indexOf(s),
                    stringBuilder.indexOf(s) + s.length(),
                    stringBuilder1.toString());
        }
    }
}
