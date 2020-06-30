package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(filename1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filename2));
        String s;
        while ((s = reader1.readLine()) != null){
            allLines.add(s);
        }
        while ((s = reader2.readLine()) != null){
            forRemoveLines.add(s);
        }
        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {
        for (String forRemoveLine : forRemoveLines){
            boolean a = false;
            for (String allLine: allLines){
                if (allLine.equals(forRemoveLine)) {
                    a = true;
                    break;
                }
            }
            if(!a) {
                allLines.clear();
                throw new CorruptedDataException();
            } else {
                allLines.remove(forRemoveLine);
            }
        }
    }
}
