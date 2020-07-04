package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();
        int a = 0;
        while (fileReader.ready()){
            if (a == -1) {
                a = fileReader.read();
                fileWriter.write(a);
            //    fileWriter.flush();
            } else {
                a = fileReader.read();
                a = -1;
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
