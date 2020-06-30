package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-c")){
                i++;
                String name = args[i];
                i++;
                String sex = args[i];
                i++;
                Date date = dateFormat1.parse(args[i]);
                if (sex.equals("м")){
                    allPeople.add(Person.createMale(name, date));
                } else if (sex.equals("ж")){
                    allPeople.add(Person.createFemale(name, date));
                }
                System.out.println(allPeople.size()-1);
            }
            if (args[i].equals("-u")){
                i++;
                int id = Integer.parseInt(args[i]);
                i++;
                String name = args[i];
                i++;
                String sexValue = args[i];
                i++;
                Date date = dateFormat1.parse(args[i]);
                Sex sex;
                if (sexValue.equals("м")){
                    sex = Sex.MALE;
                } else {
                    sex = Sex.FEMALE;
                }
                allPeople.get(id).setBirthDate(date);
                allPeople.get(id).setName(name);
                allPeople.get(id).setSex(sex);
            }
            if (args[i].equals("-d")){
                i++;
                int id = Integer.parseInt(args[i]);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
            }
            if (args[i].equals("-i")){
                i++;
                int id = Integer.parseInt(args[i]);
                String sexValue;
                if (allPeople.get(id).getSex().equals(Sex.MALE)){
                    sexValue = "м";
                } else {
                    sexValue = "ж";
                }
                System.out.println(allPeople.get(id).getName() + " " + sexValue + " " + dateFormat2.format(allPeople.get(id).getBirthDate()));
            }
        }
    }
}
