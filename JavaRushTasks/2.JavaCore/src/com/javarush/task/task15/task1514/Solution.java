package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.5, "3/2");
        labels.put(1.6, "8/5");
        labels.put(1.7, "17/10");
        labels.put(1.8, "9/5");
        labels.put(2.0, "2");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
