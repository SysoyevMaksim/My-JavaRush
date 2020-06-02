package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0, sum = 0, number = 0;
        while (input != -1)
        {
            sum += input;
            number++;
            String s = reader.readLine();
            input = Integer.parseInt(s);
        }
        number--;
        double result = sum/(double)number;
        System.out.println(result);
    }
}

