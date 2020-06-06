package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            strings.add(reader.readLine());
        }
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int i = 4;
        int length = strings.get(i).length();
        while (strings.get(i).length() == length && i > 0){
            System.out.println(strings.get(i));
            i--;
        }
    }
    public static boolean compare(String s1, String s2){
        return s1.length() > s2.length();
    }
}
