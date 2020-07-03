package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(filename));
        ArrayList<Pair<Integer, String>> arrayList = new ArrayList<Pair<Integer, String>>();
        while (true) {
            String s = reader1.readLine();
            if (s == null) {
                break;
            }
            String idStr = s.substring(0, 8);
            String value = s.substring(8);
            if (idStr.contains(" ")){
                idStr = idStr.substring(0, idStr.indexOf(" "));
            }
            int id = Integer.parseInt(idStr);
            arrayList.add(new Pair<>(id, value));
        }
        reader1.close();
        if (args.length > 0) {
            int id = Integer.parseInt(args[1]);
            int coords = 0;
            for (int i = 0; i < arrayList.size(); i++){
                if (arrayList.get(i).getKey() == id){
                    coords = i;
                }
            }
            if (args[0].equals("-d")){
                arrayList.remove(coords);
            } else {
                StringBuilder productName = new StringBuilder(args[2]);
                StringBuilder price = new StringBuilder(args[args.length - 2]);
                StringBuilder quantity = new StringBuilder(args[args.length - 1]);
                if (args.length > 5) {
                    for (int i = 2; i < args.length - 2; i++) {
                        productName.append(" ");
                        productName.append(args[i]);
                    }
                }
                while (productName.length() < 30) {
                    productName.append(" ");
                }
                while (price.length() < 8) {
                    price.append(" ");
                }
                while (quantity.length() < 4) {
                    quantity.append(" ");
                }
                if (productName.length() > 30){
                    productName = new StringBuilder(productName.substring(0, 30));
                }
                String s = productName.toString() + price.toString() + quantity.toString();
                arrayList.set(coords, new Pair<>(arrayList.get(coords).getKey(), s));
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < arrayList.size()-1; i++) {
                Pair<Integer, String> pair = arrayList.get(i);
                StringBuilder idStr = new StringBuilder(pair.getKey().toString());
                while (idStr.length() < 8) {
                    idStr.append(" ");
                }
                String s = idStr.toString() + pair.getValue();
                bufferedWriter.write(s + "\n");
            }
            Pair<Integer, String> pair = arrayList.get(arrayList.size()-1);
            StringBuilder idStr = new StringBuilder(pair.getKey().toString());
            while (idStr.length() < 8) {
                idStr.append(" ");
            }
            String s = idStr.toString() + pair.getValue();
            bufferedWriter.write(s + "");
            bufferedWriter.close();
        }
    }
}
