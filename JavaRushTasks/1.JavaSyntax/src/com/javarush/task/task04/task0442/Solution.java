package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0, sum = 0;
        while (input != -1)
        {
            String s = reader.readLine();
            input = Integer.parseInt(s);
            sum += input;
        }
        System.out.println(sum);
    }
}
