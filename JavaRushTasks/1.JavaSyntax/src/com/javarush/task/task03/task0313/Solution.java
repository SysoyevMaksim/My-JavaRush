package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s1 = "Мама";
        String s2 = "Мыла";
        String s3 = "Раму";
        System.out.println(s1 + s2 + s3);
        System.out.println(s1 + s3 +s2);
        System.out.println(s2 + s1 + s3);
        System.out.println(s2 + s3 + s1);
        System.out.println(s3 + s1 + s2);
        System.out.println(s3 + s2 + s1);
    }
}
