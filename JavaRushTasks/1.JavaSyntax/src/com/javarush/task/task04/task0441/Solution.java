package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        int d = min(a, b, c);
        int e = max(a, b, c);
        if (a == b || a == c || b == c) {
            if (b != c) {
                System.out.println(a);
            } else {
                System.out.println(b);
            }
        } else {
            if (a != d && a != e) {
                System.out.println(a);
            } else {
                if (b != d && b != e) {
                    System.out.println(b);
                } else {
                    System.out.println(c);
                }
            }
        }
    }

    public static int min(int a, int b, int c) {
        if (min(a, b) < min(b, c)) {
            return min(a, b);
        } else {
            return min(b, c);
        }
    }

    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(int a, int b, int c) {
        if (max(a, b) > max(b, c)) {
            return max(a, b);
        } else {
            return max(b, c);
        }
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
