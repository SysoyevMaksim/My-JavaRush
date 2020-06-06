package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        for (int i = 0; i < 20; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }
        System.arraycopy(array, 0, array1, 0, 10);
        System.arraycopy(array, 10, array2, 0, 10);
        for (int value : array2) {
            System.out.println(value);
        }
    }
}
