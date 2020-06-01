package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        boolean a = (n >= 100);
        boolean b = (n >= 10);
        boolean c = (n % 2 == 0);
        if (n >= 1 && n <= 999) {
            if (c) {
                System.out.print("четное ");
            } else {
                System.out.print("нечетное ");
            }
            if (a) {
                System.out.print("трехзначное ");
            } else {
                if (b) {
                    System.out.print("двузначное ");
                } else {
                    System.out.print("однозначное ");
                }
            }
            System.out.println("число");
        }
    }
}
