package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        System.out.print("количество дней в году: ");
        if(n % 400 == 0)
        {
            System.out.println(366);
        }
        else
        {
            if(n % 100 == 0)
            {
                System.out.println(365);
            }
            else
            {
                if(n % 4 == 0)
                {
                    System.out.println(366);
                }
                else
                {
                    System.out.println(365);
                }
            }
        }
    }
}