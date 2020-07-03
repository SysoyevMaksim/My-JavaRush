package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName, targetFileName;
        ArrayList<String> collectNames = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            fileName = scanner.nextLine();
            if (fileName.equals("end"))
                break;
            collectNames.add(fileName);
        }
        scanner.close();

        String[] colNames = new String[100];
        for (String s : collectNames) {
            String w = s.substring(s.lastIndexOf("t") + 1);
            colNames[Integer.parseInt(w)] = s;
        }
        collectNames.clear();
        for (int i = 0; i < colNames.length; i++) {
            if (colNames[i] != null)
                collectNames.add(colNames[i]);
        }

        targetFileName = collectNames.get(0).substring(0, collectNames.get(0).lastIndexOf("."));
        File file = new File(targetFileName);
        FileOutputStream fos = new FileOutputStream(file);

        for (int i = 0; i < collectNames.size(); i++) {
            FileInputStream fis = new FileInputStream(collectNames.get(i));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();

    }
}