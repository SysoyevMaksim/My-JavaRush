package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            FileInputStream fileInputStream = new FileInputStream("Noname.txt");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            String s = null;
            s.length();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {
            int[] ints = new int[1];
            System.out.println(ints[2]);
        } catch (Exception e){
            exceptions.add(e);
        }
        try {
            int i = Integer.parseInt("s");
        } catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw new My1();
        }
        catch (My1 e){
            exceptions.add(e);
        }
        try {
            throw new My2();
        }
        catch (My2 e){
            exceptions.add(e);
        }
        try {
            throw new My3();
        }
        catch (My3 e){
            exceptions.add(e);
        }
        try {
            throw new My4();
        }
        catch (My4 e){
            exceptions.add(e);
        }
        try {
            throw new My5();
        }
        catch (My5 e){
            exceptions.add(e);
        }
    }

    private static class My1 extends Exception{

    }
    private static class My2 extends Exception{

    }
    private static class My3 extends Exception{

    }
    private static class My4 extends Exception{

    }
    private static class My5 extends Exception{

    }
}
