package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sm = reader.readLine(), sn = reader.readLine();
        int m = Integer.parseInt(sm), n = Integer.parseInt(sn);
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
            {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
