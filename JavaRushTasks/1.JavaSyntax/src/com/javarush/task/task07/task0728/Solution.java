package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/* 
В убывающем порядке
*/

public class Solution {
    private static Object Employee;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        final int[] array2 = IntStream.of(array).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        for (int i = 0; i < array2.length; i++){
            array[i] = array2[i];
        }
//        for (int value : array2) {
//            System.out.println(value);
//        }
    }
}
