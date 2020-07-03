package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")){
            ReadThread readThread = new ReadThread(s);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        String filename;
        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            while (true) {
                try {
                    assert fileInputStream != null;
                    if (!(fileInputStream.available() > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int input = 0;
                try {
                    input = fileInputStream.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (hashMap.containsKey(input)){
                    hashMap.put(input, hashMap.get(input)+1);
                } else {
                    hashMap.put(input, 1);
                }
            }
            int max = -1, max_key = 0;
            for (HashMap.Entry<Integer, Integer> pair : hashMap.entrySet()){
                if (pair.getValue() > max || max == -1){
                    max = pair.getValue();
                    max_key = pair.getKey();
                }
            }
            resultMap.put(filename, max_key);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
