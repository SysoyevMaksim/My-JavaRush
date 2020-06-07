package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i = 0; i < strings.size(); i++){
            boolean a = false;
            boolean b = false;
            String s = strings.get(i);
            for (int j = 0; j < s.length(); j++)
            {
                if(s.charAt(j) == 'р') a = true;
                if(s.charAt(j) == 'л') b = true;
            }
            if(!(a && b)){
                if(a){
                    strings.remove(i);
                    i--;
                }
                if(b) {
                    strings.add(i, s);
                    i++;
                }
            }
        }
        return strings;
    }
}