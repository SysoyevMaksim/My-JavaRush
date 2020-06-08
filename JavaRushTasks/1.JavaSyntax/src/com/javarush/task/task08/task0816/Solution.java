package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Сталлон", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталло", dateFormat.parse("MAY 2 2012"));
        map.put("Сталл", dateFormat.parse("JUNE 2 2012"));
        map.put("Стал", dateFormat.parse("MAY 3 2012"));
        map.put("Ста", dateFormat.parse("JUNE 3 2012"));
        map.put("Ст", dateFormat.parse("MAY 4 2012"));
        map.put("С", dateFormat.parse("JUNE 4 2012"));
        map.put("Сталлонее", dateFormat.parse("MAY 5 2012"));
        map.put("Сталлонеее", dateFormat.parse("JUNE 5 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry<String, Date> pair : map.entrySet()){
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7){
                arrayList.add(pair.getKey());
            }
        }
        for (String s : arrayList){
            map.remove(s);
        }
    }

    public static void main(String[] args) throws ParseException {
        /*Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }*/
    }
}
