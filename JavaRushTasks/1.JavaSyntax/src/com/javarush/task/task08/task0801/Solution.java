package com.javarush.task.task08.task0801;

/* 
Set из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Set<String> Set = new HashSet<String>();
        Set.add("арбуз");
        Set.add("банан");
        Set.add("вишня");
        Set.add("груша");
        Set.add("дыня");
        Set.add("ежевика");
        Set.add("женьшень");
        Set.add("земляника");
        Set.add("ирис");
        Set.add("картофель");
        for (String s : Set){
            System.out.println(s);
        }
    }
}
