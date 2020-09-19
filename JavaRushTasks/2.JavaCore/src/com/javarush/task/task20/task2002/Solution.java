package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:/GitKraken/test.txt");
            InputStream inputStream = new FileInputStream("C:/GitKraken/test.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            javaRush.users.add(new User());
//            javaRush.users.add(new User());
//            javaRush.users.get(0).setBirthDate(new Date());
//            javaRush.users.get(0).setFirstName("1");
//            javaRush.users.get(0).setLastName("2");
//            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
//            javaRush.users.get(0).setMale(true);
//            javaRush.users.get(1).setBirthDate(new Date());
//            javaRush.users.get(1).setFirstName("3");
//            javaRush.users.get(1).setLastName("4");
//            javaRush.users.get(1).setCountry(User.Country.UKRAINE);
//            javaRush.users.get(1).setMale(false);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println((loadedObject.equals(javaRush)));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String isUsersPresent = !users.isEmpty() ? "yes" : "no";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(isUsersPresent);
            writer.newLine();
//            writer.write(String.valueOf(new Date((long) (1595311.948775 * 1000000))));
            if (!users.isEmpty()){
                for (int i = 0; i < users.size() - 1; i++){
                    User user = users.get(i);
                    writer.write(user.getFirstName() + " " + user.getLastName() + " " + user.getBirthDate().getTime() + " " + user.isMale() + " " + user.getCountry().getDisplayName());
                    writer.newLine();
                }
                User user = users.get(users.size()-1);
                writer.write(user.getFirstName() + " " + user.getLastName() + " " + user.getBirthDate().getTime() + " " + user.isMale() + " " + user.getCountry().getDisplayName());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersPresent = reader.readLine();
            if (isUsersPresent.equals("no")){
                return;
            }
            int i = 0;
            while (reader.ready()){
                users.add(new User());
                String data = reader.readLine();
                int j = 0;
                for (String s : data.split(" ")){
                    if (j == 0){
                        users.get(i).setFirstName(s);
                    } else if (j == 1){
                        users.get(i).setLastName(s);
                    } else if (j == 2){
                        users.get(i).setBirthDate(new Date(Long.parseLong(s)));
                    } else if (j == 3){
                        users.get(i).setMale(Boolean.parseBoolean(s));
                    } else if (j == 4){
                        users.get(i).setCountry(User.Country.valueOf(s.toUpperCase()));
                    }
                    j++;
                }
                i++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return Objects.equals(users, javaRush.users);

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
