package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("C://GitKraken//", "test.txt");
            OutputStream outputStream = new FileOutputStream("C:/GitKraken/test.txt");
            InputStream inputStream = new FileInputStream("C:/GitKraken/test.txt");

            Human ivanov = new Human("Ivanov",null);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.equals(ivanov));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (!Objects.equals(name, human.name)) return false;
            return Objects.equals(assets, human.assets);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String isAssetsPresent = !assets.isEmpty() ? "yes" : "no";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(isAssetsPresent);
            writer.newLine();
            writer.flush();
            writer.write(name);
            if (!assets.isEmpty()){
                writer.newLine();
                for (int i = 0; i < assets.size() - 1; i++){
                    writer.write(assets.get(i).getName() + " " + assets.get(i).getPrice() + " ");
                }
                writer.write(assets.get(assets.size()-1).getName() + " " + assets.get(assets.size()-1).getPrice());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isAssetsPresent = reader.readLine();
            this.name = reader.readLine();
            if (isAssetsPresent.equals("yes")){
                this.assets.clear();
                String s = reader.readLine();
                int i1 = 0;
                int i2 = s.indexOf(' ');
                int i3 = s.indexOf(' ', i2 + 1);
                while (i2 != -1){
                    String s1 = s.substring(i1, i2);
                    String s2;
                    if (i3 != -1){
                        s2 = s.substring(i2 + 1, i3);
                    } else {
                        s2 = s.substring(i2 + 1);
                    }
                    double d = Double.parseDouble(s2);
                    assets.add(new Asset(s1, d));
                    if (i3 != -1) {
                        i1 = i3 + 1;
                        i2 = s.indexOf(' ', i1);
                        i3 = s.indexOf(' ', i2 + 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
