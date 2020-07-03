package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        HashSet<Integer> hashSet = new HashSet<Integer>();
        while (fileInputStream.available() > 0){
            hashSet.add(fileInputStream.read());
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(hashSet);
        arrayList.sort(Comparator.naturalOrder());
        for (Integer integer : arrayList){
            System.out.print(integer + " ");
        }
        fileInputStream.close();
        reader.close();
    }
}
