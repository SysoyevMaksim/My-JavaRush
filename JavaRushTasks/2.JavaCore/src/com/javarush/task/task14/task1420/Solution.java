package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(reader.readLine());
        long y = Integer.parseInt(reader.readLine());
        if (x <= 0 || y <= 0) {
            throw new Exception();
        }
        while (x > 0 && y > 0) {
            if (x > y) {
                x %= y;
            } else {
                y %= x;
            }
            //System.out.println(x + " " + y);
        }
        System.out.println(x + y);
    }
}
