package com.javarush.task.task19.task1924;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();
        main_change(stringBuilder);
        System.out.println(stringBuilder);
    }

    private static boolean isInteger(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void main_change(StringBuilder stringBuilder){
        for (String s : stringBuilder.toString().split("\n")){
            StringBuilder stringBuilder1 = new StringBuilder();
            for (String s1 : s.split(" ")){
                if (isInteger(s1)){
                    int value = Integer.parseInt(s1);
                    if (Test(value)){
                        s1 = map.get(value);
                    }
                }
                stringBuilder1.append(s1).append(" ");
            }
            stringBuilder1.deleteCharAt(stringBuilder1.length()-1);
            stringBuilder.replace(stringBuilder.indexOf(s),
                    stringBuilder.indexOf(s) + s.length(),
                    stringBuilder1.toString());
        }
    }

    private static boolean Test(int i){
        return i <= 12 && i >= 0;
    }
}
