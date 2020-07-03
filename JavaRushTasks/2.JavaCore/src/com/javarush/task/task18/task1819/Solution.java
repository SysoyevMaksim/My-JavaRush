package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(s);
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (fileInputStream2.available() > 0){
            arrayList.add(fileInputStream2.read());
        }
        while (fileInputStream1.available() > 0){
            arrayList.add(fileInputStream1.read());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(s);
        for (Integer i : arrayList){
            fileOutputStream.write(i);
        }
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
