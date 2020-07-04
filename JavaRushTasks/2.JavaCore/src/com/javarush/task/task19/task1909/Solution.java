package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        String s;
        while ((s = fileReader.readLine()) != null){
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '.'){
                    stringBuilder.setCharAt(i, '!');
                }
            }
            fileWriter.write(stringBuilder.toString());
        }
        fileReader.close();
        fileWriter.close();
    }
}
