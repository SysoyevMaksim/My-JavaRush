package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream console = System.out;
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);
        String result = outputStream.toString();
        StringBuilder stringBuilder = new StringBuilder(result);
        int i = 3;
        int position = stringBuilder.indexOf("\n");
        while (position != -1){
            if (i % 4 == 0){
                i = 1;
                stringBuilder.insert(position + 1,  "JavaRush - курсы Java онлайн" + "\n");
            }
            i++;
            position = stringBuilder.indexOf("\n", position+1);
        }
        System.out.println(stringBuilder);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
