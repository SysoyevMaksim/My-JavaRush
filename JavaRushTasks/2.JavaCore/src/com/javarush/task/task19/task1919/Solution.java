package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import javafx.util.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> hashMap = new HashMap<>();
        FileReader fileReader = new FileReader(args[0]);
        while (fileReader.ready()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int c = fileReader.read();
                if (c == -1){
                    if (!stringBuilder.toString().equals("")){
                        transform(stringBuilder.toString(), hashMap);
                    }
                    break;
                }
                if (c == '\n' || c == '\r'){
                    if (!stringBuilder.toString().equals("")){
                        transform(stringBuilder.toString(), hashMap);
                    }
                    break;
                } else {
                    stringBuilder.append((char) c);
                }
            }
        }
        fileReader.close();
        ArrayList<Pair<String, Double>> arrayList = new ArrayList<>();
        for (HashMap.Entry<String, Double> pair : hashMap.entrySet()){
            arrayList.add(new Pair<>(pair.getKey(), pair.getValue()));
        }
        arrayList.sort(new MyComparator());
        for (Pair<String, Double> pair : arrayList){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static void transform(String s, HashMap<String, Double> hashMap){
        int i1 = s.indexOf(' ');
        double d = Double.parseDouble(s.substring(i1+1));
        String s1 = s.substring(0, i1);
        add(s1, d, hashMap);
    }

    private static void add(String s, double d, HashMap<String, Double> hashMap){
        if (hashMap.containsKey(s)){
            hashMap.put(s, hashMap.get(s) + d);
        } else {
            hashMap.put(s, d);
        }
    }

    static class MyComparator implements Comparator<Pair<String, Double>>{

        public int compare(Pair<String, Double> a, Pair<String, Double> b){

            return a.getKey().compareTo(b.getKey());
        }
    }
}
