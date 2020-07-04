package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ((s = fileReader.readLine()) != null){
            for (int i = 0; i < s.length(); i++) {
                int input = s.charAt(i);
                if (input == ' ') {
                    if (test(stringBuilder.toString())) {
                        fileWriter.write(stringBuilder.toString() + " ");
                    }
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append((char) input);
                }
            }
        }
        fileReader.close();
        if (test(stringBuilder.toString())){
            fileWriter.write(stringBuilder.toString() + " ");
        }
        fileWriter.close();
    }

    private static boolean test(String s){
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
