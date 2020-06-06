package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[15];
        int chot = 0;
        int nechot = 0;
        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
            if(i % 2 == 0){
                chot += array[i];
            }
            else {
                nechot += array[i];
            }
        }
        if(chot > nechot){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
