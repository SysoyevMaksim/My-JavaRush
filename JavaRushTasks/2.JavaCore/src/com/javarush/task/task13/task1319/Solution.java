package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

/*import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String input = "";
        while (!input.equals("exit")){
            input = reader.readLine();
            System.out.println(input);
            writer.write(input);
        }
    }
}*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            writer.write(line + System.lineSeparator());
        }
        writer.write("exit" + System.lineSeparator());
        writer.close();
        reader.close();
    }

}