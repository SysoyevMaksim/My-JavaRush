package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine(), sb = reader.readLine(), sc = reader.readLine();
        int a = Integer.parseInt(sa), b = Integer.parseInt(sb), c = Integer.parseInt(sc);
        if(a == b && a == c) System.out.println(a + " " + b + " " + c);
        else
        {
            if(a == b) System.out.println(a + " " + b);
            if(a == c) System.out.println(a + " " + c);
            if(b == c) System.out.println(b + " " + c);
        }
    }
}