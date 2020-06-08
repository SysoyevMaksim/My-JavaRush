package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("q", "Max");
        map.put("1", "Min");
        map.put("2", "q");
        map.put("3", "w");
        map.put("r", "e");
        map.put("t", "r");
        map.put("y", "t");
        map.put("4", "y");
        map.put("w", "q");
        map.put("e", "w");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values()){
            if(s.equals(name)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.keySet()){
            if(s.equals(lastName)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
