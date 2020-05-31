package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String N = reader.readLine();
        int n = Integer.parseInt(N);
        int i = 0;
        while (i < n)
        {
            System.out.println(s);
            i++;
        }
    }
}
