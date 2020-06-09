package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> people = new HashMap<String, String>();
        people.put("1", "1");
        people.put("2", "1");
        people.put("2", "2");
        people.put("3", "3");
        people.put("5", "4");
        people.put("4", "5");
        people.put("6", "8");
        people.put("8", "8");
        people.put("7", "8");
        people.put("2", "2");
        return people;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
