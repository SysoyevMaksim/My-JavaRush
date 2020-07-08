package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder s = new StringBuilder();
        while (fileReader.ready()) {
            int input = fileReader.read();
            if ((char) input != '\r' && (char) input != '\n') {
                s.append((char) input);
            }
        }
        fileReader.close();
        String target = args[0];
        String target_end = "/" + target;
        target = "<" + target;
        target_end = "<" + target_end + ">";
        int i1 = -1, i2;
        while ((i1 = s.indexOf(target, i1 + 1)) != -1) {
            i2 = i1 + 1;
            i2 = s.indexOf(target_end, i2);
            int i3 = i1;
            while ((i3 = s.indexOf(target, i3 + 1)) < i2 && i3 > -1) {
//                System.out.println(i3 + " " + i2);
                i2 = s.indexOf(target_end, i2 + 1);
//                System.out.println(i3 + " " + i2);
            }
//            System.out.println(":");
//            System.out.println(i1 + " " + i2);
            System.out.println(s.substring(i1, i2 + 2 + target.length()));
        }
    }
}
