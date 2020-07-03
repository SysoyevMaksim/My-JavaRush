package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        if (fileInputStream.available() > 0) {
            int i = fileInputStream.available();
            int for2 = i / 2;
            int for3 = i / 2;
            if (i % 2 == 1) {
                for2++;
            }
            byte[] input = new byte[i];
            int count = fileInputStream.read(input);
            fileOutputStream1.write(input, 0, for2);
            fileOutputStream2.write(input, for2, for3);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
