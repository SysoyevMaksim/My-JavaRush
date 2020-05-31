package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String nomber1 = reader.readLine();
        String nomber2 = reader.readLine();
        System.out.println(name + " получает " + nomber1 + " через " + nomber2 + " лет.");
    }
}
