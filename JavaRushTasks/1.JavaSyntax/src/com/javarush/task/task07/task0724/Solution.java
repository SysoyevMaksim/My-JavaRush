package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandad1 = new Human("1.1", true, 3);
        Human grandad2 = new Human("1.2", true, 3);
        Human granny1 = new Human("1.3", false, 3);
        Human granny2 = new Human("1.4", false, 3);
        Human father = new Human("2.1", true, 2, grandad1, granny1);
        Human mother = new Human("2.2", false, 2, grandad2, granny2);
        Human child1 = new Human("3.1", true, 1, father, mother);
        Human child2 = new Human("3.2", false, 1, father, mother);
        Human child3 = new Human("3.2", true, 1, father, mother);
        System.out.println(grandad1);
        System.out.println(grandad2);
        System.out.println(granny1);
        System.out.println(granny2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}