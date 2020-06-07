package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            integers.add(Integer.parseInt(reader.readLine()));
        }
        ArrayList <Integer> integers1 = new ArrayList<Integer>();
        ArrayList <Integer> integers2 = new ArrayList<Integer>();
        ArrayList <Integer> integers3 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            if(integers.get(i) % 3 == 0){
                integers1.add(integers.get(i));
            }
            else {
                if (integers.get(i) % 2 == 0) {
                    integers2.add(integers.get(i));
                    continue;
                }
                else {
                    integers3.add(integers.get(i));
                    continue;
                }
            }
            if (integers.get(i) % 2 == 0){
                integers2.add(integers.get(i));
            }
        }
        printList(integers1);
        printList(integers2);
        printList(integers3);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
