package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M yyyy");
        FileReader fileReader = new FileReader(args[0]);
        while (fileReader.ready()) {
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                int c = fileReader.read();
                if (c == -1) {
                    if (!stringBuilder.toString().equals("")) {
                        String s = stringBuilder.toString();
                        int i1 = 0, i2 = -1, i3 = -1, i4 = -1;
                        while ((i1 = s.indexOf(' ', i1 + 1)) != -1) {
                            i4 = i3;
                            i3 = i2;
                            i2 = i1;
                        }
                        String s1 = s.substring(0, i4);
                        String s2 = s.substring(i4 + 1);
                        PEOPLE.add(new Person(s1, simpleDateFormat.parse(s2)));
                    }
                    break;
                }
                if (c == '\n' || c == '\r') {
                    if (!stringBuilder.toString().equals("")) {
                        String s = stringBuilder.toString();
                        int i1 = 0, i2 = -1, i3 = -1, i4 = -1;
                        while ((i1 = s.indexOf(' ', i1 + 1)) != -1) {
                            i4 = i3;
                            i3 = i2;
                            i2 = i1;
                        }
                        String s1 = s.substring(0, i4);
                        String s2 = s.substring(i4 + 1);
                        PEOPLE.add(new Person(s1, simpleDateFormat.parse(s2)));
                    }
                    break;
                } else {
                    stringBuilder.append((char) c);
                }
            }
        }
        fileReader.close();
    }
}
