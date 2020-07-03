package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (input == 45){
                stringBuilder.append('-');
                continue;
            }
            if (input == 46){
                stringBuilder.append('.');
                continue;
            }
            if (input == 32){
                long d = Math.round(Double.parseDouble(stringBuilder.toString()));
                String s = Long.toString(d);
                for (int i = 0; i < s.length(); i++){
                    fileOutputStream.write(s.charAt(i));
                }
                fileOutputStream.write(' ');
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(input - 48);
        }
        long d = Math.round(Double.parseDouble(stringBuilder.toString()));
        String s = Long.toString(d);
        for (int i = 0; i < s.length(); i++){
            fileOutputStream.write(s.charAt(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
