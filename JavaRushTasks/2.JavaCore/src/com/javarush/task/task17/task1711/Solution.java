package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]){
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        String name = args[i];
                        i++;
                        String sex = args[i];
                        i++;
                        Date date = dateFormat1.parse(args[i]);
                        if (sex.equals("м")) {
                            allPeople.add(Person.createMale(name, date));
                        } else if (sex.equals("ж")) {
                            allPeople.add(Person.createFemale(name, date));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                    break;
                }
            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        i++;
                        String name = args[i];
                        i++;
                        String sexValue = args[i];
                        i++;
                        Date date = dateFormat1.parse(args[i]);
                        Sex sex;
                        if (sexValue.equals("м")) {
                            sex = Sex.MALE;
                        } else {
                            sex = Sex.FEMALE;
                        }
                        allPeople.get(id).setBirthDate(date);
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex(sex);
                    }
                    break;
                }
            case ("-i"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        String sexValue;
                        if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                            sexValue = "м";
                        } else {
                            sexValue = "ж";
                        }
                        System.out.println(allPeople.get(id).getName() + " " + sexValue + " " + dateFormat2.format(allPeople.get(id).getBirthDate()));
                    }
                    break;
                }
        }
    }
}
