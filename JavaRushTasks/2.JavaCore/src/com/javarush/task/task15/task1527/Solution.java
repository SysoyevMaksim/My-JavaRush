package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        StringBuilder argument = new StringBuilder();
        ArrayList<String> arguments = new ArrayList<String>();
        StringBuilder value = new StringBuilder();
        boolean next_is_argument = false, have_odj = false, need_value = false;
        for (int i = 0; i < URL.length(); i++){
            char c = URL.charAt(i);
            if (c == '?' || c == '&'){
                need_value = false;
                if (!argument.toString().equals("")){
                    arguments.add(argument.toString());
                    if (argument.toString().equals("obj")){
                        have_odj = true;
                        need_value = true;
                    }
                    argument = new StringBuilder();
                    next_is_argument = false;
                }
                next_is_argument = true;
                continue;
            }
            if (need_value){
                if (c != '='){
                    value.append(c);
                }
            }
            if (c >= 97 && c <= 122 && next_is_argument){
                argument.append(c);
            } else if (!argument.toString().equals("")){
                arguments.add(argument.toString());
                if (argument.toString().equals("obj")){
                    have_odj = true;
                    need_value = true;
                }
                argument = new StringBuilder();
                next_is_argument = false;
            }
        }
        for (String s : arguments){
            System.out.print(s + " ");
        }
        if (have_odj){
            System.out.println();
            if (isDouble(value.toString())){
                alert(Double.parseDouble(value.toString()));
            }
            else {
                alert(value.toString());
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static boolean isDouble(String s){
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
