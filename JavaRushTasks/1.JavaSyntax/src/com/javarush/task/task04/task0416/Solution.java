package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double n1 = Double.parseDouble(s);
        int n = (int)n1;
        n %= 5;
        if (n == 0 || n == 1 || n == 2)
        {
            System.out.println("зелёный");
        }
        if (n == 3)
        {
            System.out.println("жёлтый");
        }
        if (n == 4)
        {
            System.out.println("красный");
        }
    }
}