package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

// -c Шорты пляжные черные с рисунком 159.00 12

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(filename));
        ArrayList<String> strings = new ArrayList<String>();
        int maxId = -1;
        while (true) {
            String s = reader1.readLine();
            if (s == null) {
                break;
            }
            strings.add(s);
            String idstr = s.substring(0, 8);
            if (idstr.contains(" ")){
                idstr = idstr.substring(0, idstr.indexOf(" "));
            }
            int id = Integer.parseInt(idstr);
            if (maxId == -1 || maxId < id) {
                maxId = id;
            }
        }
        reader1.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < strings.size() - 1; i++) {
            bufferedWriter.write(strings.get(i) + "\n");
        }
        bufferedWriter.write(strings.get(strings.size()-1) + "");
        if (args.length >= 4) {
            if (args[0].equals("-c")) {
                StringBuilder productName = new StringBuilder(args[1]);
                StringBuilder price = new StringBuilder(args[args.length - 2]);
                StringBuilder quantity = new StringBuilder(args[args.length - 1]);
                StringBuilder id = new StringBuilder(((Integer) (maxId + 1)).toString());
                if (args.length > 4) {
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
                while (id.length() < 8) {
                    id.append(" ");
                }
                if (productName.length() > 30){
                    productName = new StringBuilder(productName.substring(0, 30));
                }
                String s = id.toString() + productName.toString() + price.toString() + quantity.toString();
                bufferedWriter.write("\n" + s);
            }
        }
        bufferedWriter.close();
    }
}
