package com.javarush.task.task03.task0325;

/* 
Финансовые ожидания
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        System.out.println("Я буду зарабатывать $" + n + " в час");
    }
}
