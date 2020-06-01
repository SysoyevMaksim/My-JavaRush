package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        if(n == 0) {
            System.out.println("ноль");
        }
        else{
            if(n > 0)
            {
                System.out.print("положительное ");
            }
            if(n < 0)
            {
                System.out.print("отрицательное ");
            }
            if(n % 2 == 1 || n % 2 == -1)
            {
                System.out.print("нечетное ");
            }
            if(n % 2 == 0)
            {
                System.out.print("четное ");
            }
            System.out.println("число");
        }
    }
}
