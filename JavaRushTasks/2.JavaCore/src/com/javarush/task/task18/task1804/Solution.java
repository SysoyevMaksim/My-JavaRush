package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (hashMap.containsKey(input)){
                hashMap.put(input, hashMap.get(input)+1);
            } else {
                hashMap.put(input, 1);
            }
        }
        int min = -1;
        for (Integer integer : hashMap.values()){
            if (min > integer || min == -1){
                min = integer;
            }
        }
        for (HashMap.Entry<Integer, Integer> pair : hashMap.entrySet()){
            if (pair.getValue() == min){
                System.out.print(pair.getKey() + " ");
            }
        }
        fileInputStream.close();
        reader.close();
    }
}
