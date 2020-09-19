package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    static Properties properties = new Properties();

    static FileInputStream fos;

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        //properties.load(fos);
        properties.putAll(runtimeStorage);
        properties.store(outputStream, null);
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);

        for (String name : properties.stringPropertyNames()) {
            runtimeStorage.put(name, properties.getProperty(name));
        }
    }

    public static void main(String[] args) {
        runtimeStorage.put("na me", "Maksim");
        runtimeStorage.put("profession", "coder");
        runtimeStorage.put("test", "test");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            String s = reader.readLine();
            fos = new FileInputStream(s);
            FileOutputStream fos2 = new FileOutputStream(s);
            //save(fos2);
            runtimeStorage.clear();
                load(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
