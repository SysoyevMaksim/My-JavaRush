package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static boolean open = true;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        int count = 0;
        boolean b = false;
        while (open){
            if (fileReader.ready()) {
                int w = fileReader.read();
                if (b) {
                    b = false;
                    if (w == 'w') {
                        b = false;
                        if (world(fileReader)) {
                            count++;
                        }
                    }
                }
                if (w == ',' || w == ' ') b = true;
            } else {
                open = false;
            }
        }
        fileReader.close();
        System.out.println(count);
    }

    private static boolean world(FileReader fileReader) throws IOException {
        int o, r, l, d;
        if (fileReader.ready()){
            o = fileReader.read();
        } else {
            fileReader.close();
            open = false;
            return false;
        }
        if (fileReader.ready()){
            r = fileReader.read();
        } else {
            fileReader.close();
            open = false;
            return false;
        }
        if (fileReader.ready()){
            l = fileReader.read();
        } else {
            fileReader.close();
            open = false;
            return false;
        }
        if (fileReader.ready()){
            d = fileReader.read();
        } else {
            fileReader.close();
            open = false;
            return false;
        }
        return o == 'o' && r == 'r' && l == 'l' && d == 'd';
    }
}
