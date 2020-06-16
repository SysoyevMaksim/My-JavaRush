package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(filename);
        StringBuilder s = new StringBuilder("");
        boolean minus = false;
        ArrayList<Integer> integers = new ArrayList<Integer>();
        while (fileInputStream.available() > 0) {
            char c = (char) fileInputStream.read();
            if(c == 45){
                minus = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.insert(0, c);
            if ((byte) c == 10 || fileInputStream.available() <= 0) {
                if (fileInputStream.available() <= 0){
                    s.append(stringBuilder);
                }
                int i = Integer.parseInt(s.toString());
                if (minus) i *= -1;
                if (i % 2 == 0) {
                    integers.add(i);
                }
                s = new StringBuilder();
                minus = false;
            } else {
                if (c >= 47 && c <= 58){
                    s.append(stringBuilder);
                }
            }
            stringBuilder = new StringBuilder();
        }
        fileInputStream.close();
        Collections.sort(integers);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}