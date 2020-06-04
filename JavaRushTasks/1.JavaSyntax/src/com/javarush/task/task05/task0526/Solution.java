package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Вася", 6, "Москва");
        Man man2 = new Man("Славик", 20, "У мамы");
        Woman woman1 = new Woman("Татьяна", 18, "Питер");
        Woman woman2 = new Woman("Мам", 42, "Возле сыночка");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    //напишите тут ваш код
    public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
}

