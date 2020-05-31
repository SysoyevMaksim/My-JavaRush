package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        System.out.println(max(max(a, b), max(a, c)));
        if (a == max(max(a, b), max(a, c))) {
            System.out.println(max(b, c));
            System.out.println(min(b, c));
        }
        else {
            System.out.println(min(max(a, b), max(a, c)));
            System.out.println(min(min(a, b), min(a, c)));
        }

    }
    public static int min(int a, int b) {
        if(a < b) {
            return a;
        }
        else {
            return b;
        }
    }
    public static int max(int a, int b) {
        if(a > b) {
            return a;
        }
        else {
            return b;
        }
    }
}
