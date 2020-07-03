package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader1.readLine()));
        int superId = Integer.parseInt(args[0]);
        while (true){
            String s = reader.readLine();
            int id = Integer.parseInt(s.substring(0, s.indexOf(' ')));
            if (id == superId){
                System.out.println(s);
                break;
            }
        }
        reader.close();
    }
}
