package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");
        strings.add("именно");
        strings.add(2,"именно");
        strings.add(1,"именно");
        for (String s : strings){
            System.out.println(s);
        }
    }
}
