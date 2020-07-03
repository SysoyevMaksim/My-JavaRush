package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if ((input >= 65 && input <= 90)||(input >= 97 && input <= 122)){
                count++;
            }
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
