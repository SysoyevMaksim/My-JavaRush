package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        if (N > 0) {
            int maximum = Integer.parseInt(reader.readLine());
            for (int i = 1; i < N; i++) {
                int input = Integer.parseInt(reader.readLine());
                if (input > maximum) {
                    maximum = input;
                }
            }
            System.out.println(maximum);
        }
    }
}
