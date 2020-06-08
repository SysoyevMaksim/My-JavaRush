package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integers = new ArrayList<Integer>();
        int last, count = 1, max_count = 1;
        integers.add(Integer.parseInt(reader.readLine()));
        last = integers.get(0);
        for(int i = 1; i < 10; i++){
            integers.add(Integer.parseInt(reader.readLine()));
            if(integers.get(i) == last){
                count++;
            } else {
                if (max_count < count){
                    max_count = count;
                }
                count = 1;
            }
            last = integers.get(i);
        }
        if (max_count < count){
            max_count = count;
        }
        System.out.println(max_count);
    }
}