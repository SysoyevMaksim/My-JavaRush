package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(s);
            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            }
            fileInputStream.close();
        }
    }
}
