package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0, space_count = 0;
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (input == 32){
                space_count++;
            }
            count++;
        }
        double result1 = ((double)space_count / count * 100) * 100;
        int result2 = (int)Math.round(result1);
        float result = (float) result2 / 100;
        System.out.println(result);
        fileInputStream.close();
    }
}
