package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","2");
        map.put("4","2");
        map.put("5","3");
        map.put("6","3");
        map.put("7","4");
        map.put("8","4");
        map.put("9","5");
        map.put("10","6");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for (String s : map.values()){
            map1.put(s, 0);
            //System.out.println(s + " " + map1.get(s));
        }
        for (String s : map.values())
        {
            map1.put(s, map1.get(s) + 1);
            //System.out.println(s + " " + map1.get(s));
        }
        for (Map.Entry<String, Integer> pair : map1.entrySet()){
            if(pair.getValue() > 1)  removeItemFromMapByValue(map, pair.getKey());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        /*Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (String s : map.values()) System.out.println(s);*/
    }
}
