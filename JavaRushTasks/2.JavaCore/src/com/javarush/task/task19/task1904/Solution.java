package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            int i1 = s.indexOf(" ");
            String s1 = s.substring(0, i1);
            int i2 = s.indexOf(" ", i1 + 1);
            String s2 = s.substring(i1 + 1, i2);
            int i3 = s.indexOf(" ", i2 + 1);
            String s3 = s.substring(i2 + 1, i3);
            String s4 = s.substring(i3+1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = new Date();
            try {
                date = simpleDateFormat.parse(s4);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(s2, s3, s1, date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
