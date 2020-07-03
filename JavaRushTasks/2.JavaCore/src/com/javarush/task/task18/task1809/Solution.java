package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        if (fileInputStream.available() > 0) {
            byte[] input = new byte[fileInputStream.available()];
            int count = fileInputStream.read(input);
            for (int i = input.length - 1; i >= 0; i--){
                fileOutputStream.write(input[i]);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
