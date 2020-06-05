package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n > 0){
            if ((n % 10) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            n /= 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
