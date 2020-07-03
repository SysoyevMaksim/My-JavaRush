package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int min = -1;
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (min > input || min < 0){
                min = input;
            }
        }
        System.out.println(min);
        reader.close();
        fileInputStream.close();
        System.out.close();
    }
}
