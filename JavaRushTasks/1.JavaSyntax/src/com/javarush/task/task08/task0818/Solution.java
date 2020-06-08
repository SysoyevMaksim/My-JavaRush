package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 100);
        map.put("2", 200);
        map.put("3", 300);
        map.put("4", 400);
        map.put("5", 500);
        map.put("6", 600);
        map.put("7", 700);
        map.put("8", 800);
        map.put("9", 900);
        map.put("10", 10000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            if(pair.getValue() < 500) arrayList.add(pair.getKey());
        }
        for (String s : arrayList){
            map.remove(s);
        }
    }

    public static void main(String[] args) {

    }
}