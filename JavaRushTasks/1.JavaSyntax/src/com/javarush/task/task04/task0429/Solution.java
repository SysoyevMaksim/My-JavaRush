package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
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
        int a = 0, b = 0;
        if(i1 > 0) b++;
        if(i1 < 0) a++;
        if(i2 > 0) b++;
        if(i2 < 0) a++;
        if(i3 > 0) b++;
        if(i3 < 0) a++;
        System.out.println("количество отрицательных чисел: " + a);
        System.out.println("количество положительных чисел: " + b);
    }
}
