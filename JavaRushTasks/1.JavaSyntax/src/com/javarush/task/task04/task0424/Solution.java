package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int i1 = Integer.parseInt(s1), i2 = Integer.parseInt(s2), i3 = Integer.parseInt(s3);
        if (i1 != i2 && i2 == i3) {
            System.out.println(1);
        }
        if (i2 != i3 && i1 == i3) {
            System.out.println(2);
        }
        if (i3 != i1 && i1 == i2) {
            System.out.println(3);
        }
    }
}
