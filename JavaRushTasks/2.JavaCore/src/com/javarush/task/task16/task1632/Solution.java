package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Tread1());
        threads.add(new Tread2());
        threads.add(new Tread3());
        threads.add(new Tread4());
        threads.add(new Tread5());
    }

    public static void main(String[] args) {
        threads.get(4).start();
    }

    public static class Tread1 extends Thread {
        @Override
        public void run() {
            while (true) ;
        }
    }

    public static class Tread2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Tread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Tread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }
    }

    public static class Tread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int sum = 0;
            while (true) {
                try {
                    if ((s = reader.readLine()).equals("N")){
                        break;
                    }
                    else {
                        sum+= Integer.parseInt(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }
}