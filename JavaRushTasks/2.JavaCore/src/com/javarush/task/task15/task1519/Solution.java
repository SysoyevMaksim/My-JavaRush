package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = reader.readLine()).equals("exit")) {
            if (input.contains(".")) {
                if (isDouble(input)) {
                    print(Double.parseDouble(input));
                } else {
                    print(input);
                }
            } else {
                if (isInteger(input)) {
                    if (input.charAt(0) == '-' || Integer.parseInt(String.valueOf(input.charAt(0))) == 0){
                        print(Integer.parseInt(input));
                    } else {
                        if (input.length() >= 3){
                            if (test1(input) || test2(input) || test3(input)){
                                print(Integer.parseInt(input));
                            } else {
                                print(Short.parseShort(input));
                            }
                        } else {
                            print(Short.parseShort(input));
                        }
                    }
                } else {
                    print(input);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    private static boolean isInteger(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean test1(String s){
        return Integer.parseInt(String.valueOf(s.charAt(0))) > 1;
    }

    private static boolean test2(String s){
        return Integer.parseInt(String.valueOf(s.charAt(0))) == 1 &&
                Integer.parseInt(String.valueOf(s.charAt(1))) > 2;
    }

    private static boolean test3(String s){
        return Integer.parseInt(String.valueOf(s.charAt(0))) == 1 &&
                Integer.parseInt(String.valueOf(s.charAt(1))) == 2 &&
                Integer.parseInt(String.valueOf(s.charAt(2))) >= 8;
    }
}
