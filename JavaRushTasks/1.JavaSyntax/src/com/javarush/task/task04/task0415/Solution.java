package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine(), sb = reader.readLine(), sc = reader.readLine();
        int a = Integer.parseInt(sa), b = Integer.parseInt(sb), c = Integer.parseInt(sc);
        if(a >= b + c || b >= a + c || c >= a + b)
        {
            System.out.println("Треугольник не существует.");
        }
        else
        {
            System.out.println("Треугольник существует.");
        }
    }
}