package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfathername = reader.readLine();
        Cat catGrandfather = new Cat(grandfathername);

        String grannyname = reader.readLine();
        Cat catGranny = new Cat(grannyname);

        String fathername = reader.readLine();
        Cat catfather = new Cat(fathername, null, catGrandfather);
        
        String mumname = reader.readLine();
        Cat catMum = new Cat(mumname, catGranny, null);
        
        String sonnmae = reader.readLine();
        Cat catSon = new Cat(sonnmae, catMum, catfather);

        String daughtername = reader.readLine();
        Cat catDaughter = new Cat(daughtername, catMum, catfather);

        System.out.println(catGrandfather);
        System.out.println(catGranny);
        System.out.println(catfather);
        System.out.println(catMum);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mum;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mum, Cat father) {
            this.name = name;
            this.mum = mum;
            this.father = father;
        }

        @Override
        public String toString() {
            if (mum == null && father == null)
                return "The cat's name is " + name + ", no mother, no father";
            if (mum != null && father == null)
                return "The cat's name is " + name + ", mother is " + mum.name + ", no father";
            if (mum == null)
                return "The cat's name is " + name + ", no mother, father is " + father.name;
            return "The cat's name is " + name + ", mother is " + mum.name + ", father is " + father.name;
        }
    }

}
