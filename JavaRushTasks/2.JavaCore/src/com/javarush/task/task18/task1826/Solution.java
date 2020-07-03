package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String code = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
        if (code.equals("-e")){
            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read()+1);
            }
        } else {
            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read()-1);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
