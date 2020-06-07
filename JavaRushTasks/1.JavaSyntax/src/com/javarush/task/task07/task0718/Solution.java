package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        int index = -1;
        int last;
        strings.add(reader.readLine());
        last = strings.get(0).length();
        for (int i = 1; i < 10; i++){
            strings.add(reader.readLine());
            //System.out.println(strings.get(i).length() + " " + last);
            if(strings.get(i).length() <= last && index == -1) index = i;
            last = strings.get(i).length();
        }
        if(index != -1){
            System.out.println(index);
        }
    }
}

