package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
        HashMap<Integer, Integer> chars = new HashMap<Integer, Integer>();
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (chars.containsKey(input)){
                chars.put(input, chars.get(input)+1);
            } else {
                chars.put(input, 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> pair : chars.entrySet()){
            pairs.add(new Pair<>(pair.getKey(), pair.getValue()));
        }
        pairs.sort(new MyComparator());
        for (Pair<Integer, Integer> pair : pairs){
            System.out.println(String.valueOf((char)((int)pair.getKey())) + " " + pair.getValue());
        }
        fileInputStream.close();
    }
}
class MyComparator implements Comparator<Pair<Integer, Integer>> {
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.getKey() - o2.getKey();
    }
}