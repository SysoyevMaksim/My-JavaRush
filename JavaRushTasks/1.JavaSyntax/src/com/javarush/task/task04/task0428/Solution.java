package com.javarush.task.task04.task0428;

/* 
Положительное число
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
        int i = 0;
        if(i1 > 0) i++;
        if(i2 > 0) i++;
        if(i3 > 0) i++;
        System.out.println(i);
    }
}
