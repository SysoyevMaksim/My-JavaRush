package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        while (fileInputStream1.available() > 0){
            fileOutputStream.write(fileInputStream1.read());
        }
        while (fileInputStream2.available() > 0){
            fileOutputStream.write(fileInputStream2.read());
        }
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
