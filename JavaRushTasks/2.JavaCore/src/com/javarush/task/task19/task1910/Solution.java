package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        String s;
        while ((s = fileReader.readLine()) != null){
            for (int i = 0; i < s.length(); i++){
                if (!Character.isAlphabetic(s.charAt(i)) &&
                        !Character.isDigit(s.charAt(i)) &&
                        !Character.isSpaceChar(s.charAt(i))){
                    s = charRemoveAt(s, i);
                }
            }
            fileWriter.write(s);
        }
        fileReader.close();
        fileWriter.close();
        reader.close();
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
}
