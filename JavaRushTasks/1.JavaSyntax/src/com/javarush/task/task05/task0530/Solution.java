package com.javarush.task.task05.task0530;

/* 
Шеф, что-то не пашет
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine();
        String sb = reader.readLine();

        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
