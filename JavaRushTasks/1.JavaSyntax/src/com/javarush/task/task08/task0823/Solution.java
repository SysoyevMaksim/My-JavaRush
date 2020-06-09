package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(0);
        for (int i = 0; i < string.length(); i++){
            if(string.charAt(i) == ' '){
                integers.add(i+1);
            }
        }
        StringBuilder sb = new StringBuilder(string);
        for (int i : integers){
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }
        string = sb.toString();
        System.out.println(string);
    }
}
