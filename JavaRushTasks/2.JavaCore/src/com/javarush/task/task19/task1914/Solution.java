package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        StringBuilder result = new StringBuilder(outputStream.toString());
        System.setOut(consoleStream);
        int i1 = result.indexOf(" ");
        int i2 = result.indexOf(" ", i1 + 1);
        int i3 = result.indexOf(" ", i2 + 1);
        int a = Integer.parseInt(result.substring(0, i1));
        int b = Integer.parseInt(result.substring(i2+1, i3));
        String s = result.substring(i1 + 1, i2);
        //System.out.println(result);
        switch (s) {
            case "+":
                result.insert(result.length() - 1, a + b);
                break;
            case "-":
                result.insert(result.length() - 1, a - b);
                break;
            case "*":
                result.insert(result.length() - 1, a * b);
                break;
        }
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

