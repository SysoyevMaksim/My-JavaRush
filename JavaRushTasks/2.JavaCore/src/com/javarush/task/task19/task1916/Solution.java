package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(reader.readLine());
        FileReader fileReader2 = new FileReader(reader.readLine());
        ArrayList<String> fileReader1input = new ArrayList<String>();
        ArrayList<String> fileReader2input = new ArrayList<String>();
        reader.close();
        while (fileReader1.ready()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int c = fileReader1.read();
                if (c == -1){
                    if (!stringBuilder.toString().equals("")){
                        fileReader1input.add(stringBuilder.toString());
                    }
                    break;
                }
                if (c == '\n' || c == '\r'){
                    if (!stringBuilder.toString().equals("")){
                        fileReader1input.add(stringBuilder.toString());
                    }
                    break;
                } else {
                    stringBuilder.append((char) c);
                }
            }
        }
        fileReader1.close();
        while (fileReader2.ready()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int c = fileReader2.read();
                if (c == -1){
                    if (!stringBuilder.toString().equals("")){
                        fileReader2input.add(stringBuilder.toString());
                    }
                    break;
                }
                if (c == '\n' || c == '\r'){
                    if (!stringBuilder.toString().equals("")){
                        fileReader2input.add(stringBuilder.toString());
                    }
                    break;
                } else {
                    stringBuilder.append((char) c);
                }
            }
        }
        fileReader2.close();
        int i = 0, j = 0;
        for (; i < fileReader1input.size() - 1 && j < fileReader2input.size() - 1; i++, j++){
            if (fileReader1input.get(i).equals(fileReader2input.get(j))){
//                System.out.println(fileReader1input.get(i) + " " + fileReader2input.get(j));
                lines.add(new LineItem(Type.SAME, fileReader1input.get(i)));
            } else {
                if (fileReader1input.get(i + 1).equals(fileReader2input.get(j))){
//                    System.out.println(fileReader1input.get(i + 1) + " " + fileReader2input.get(j));
                    lines.add(new LineItem(Type.REMOVED, fileReader1input.get(i)));
                    i++;
                    i--;
                    j--;
                } else {
//                    System.out.println(fileReader1input.get(i) + " " + fileReader2input.get(j + 1));
                    lines.add(new LineItem(Type.ADDED, fileReader2input.get(j)));
                    j++;
                    i--;
                    j--;
                }
            }
        }
        if (fileReader1input.get(i).equals(fileReader2input.get(j))){
//                System.out.println(fileReader1input.get(i) + " " + fileReader2input.get(j));
            lines.add(new LineItem(Type.SAME, fileReader1input.get(i)));
        }
        i++;
        j++;
        if (i >= fileReader1input.size()){
            if (!(j >= fileReader2input.size())){
                lines.add(new LineItem(Type.ADDED, fileReader2input.get(j)));
            }
        } else if (j >= fileReader2input.size()){
            if (!(i >= fileReader1input.size())){
                lines.add(new LineItem(Type.REMOVED, fileReader1input.get(i)));
            }
        }
        /*for (LineItem lineItem : lines){
            System.out.println(lineItem);
        }*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        /*@Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }*/
    }
}
