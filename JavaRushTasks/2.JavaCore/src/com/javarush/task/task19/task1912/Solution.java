package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        for (int i = 0; i < result.length() - 1; i++){
            if (result.charAt(i) == 't' && result.charAt(i+1) == 'e'){
                result.setCharAt(i, '?');
                result.setCharAt(i + 1, '?');
            }
        }
        System.out.println(result.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
