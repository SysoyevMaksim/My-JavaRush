package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();
        String s = find(stringBuilder);
        fileWriter.write(s);
        fileWriter.close();
    }

    private static String find(StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String s :  stringBuilder.toString().split("\n")) {
            for (String s1 : s.split(" ")) {
                if (s1.length() > 6) {
                    stringBuilder1.append(s1).append(",");
                }
            }
        }
        if (stringBuilder1.length() > 0){
            stringBuilder1.deleteCharAt(stringBuilder1.length()-1);
        }
        return stringBuilder1.toString();
    }
}
