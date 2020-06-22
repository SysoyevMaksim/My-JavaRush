package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n < 0){
            return "0";
        }
        return factorialCounter(n).toString();
    }

    public static BigInteger factorialCounter(int n){
        if (n == 0){
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(new BigInteger(factorial(n-1)));
    }
}
