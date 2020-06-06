package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array1 = new String[10];
        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++){
            array1[i] = reader.readLine();
            array2[i] = array1[i].length();
        }
        for (int i = 0; i < 10; i++){
            System.out.println(array2[i]);
        }
    }
}
