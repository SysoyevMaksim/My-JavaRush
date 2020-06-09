package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        //напишите тут ваш код
        ArrayList<Human> null1 = new ArrayList<Human>();
        ArrayList<Human> children = new ArrayList<Human>();
        ArrayList<Human> father = new ArrayList<Human>();
        ArrayList<Human> mother = new ArrayList<Human>();
        Human child1 = new Human();
        child1.name = "Child1";
        child1.sex = true;
        child1.age = 1;
        child1.children = null1;
        Human child2 = new Human();
        child2.name = "Child2";
        child2.sex = false;
        child2.age = 1;
        child2.children = null1;
        Human child3 = new Human();
        child3.name = "Child3";
        child3.sex = true;
        child3.age = 1;
        child3.children = null1;
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human Father = new Human();
        Father.name = "Father";
        Father.sex = true;
        Father.age = 2;
        Father.children = children;
        Human Mother = new Human();
        Mother.name = "Mother";
        Mother.sex = true;
        Mother.age = 2;
        Mother.children = children;
        father.add(Father);
        mother.add(Mother);
        Human grandad1 = new Human();
        grandad1.name = "Grandad1";
        grandad1.sex = true;
        grandad1.age = 3;
        grandad1.children = father;
        Human grandad2 = new Human();
        grandad2.name = "Grandad2";
        grandad2.sex = true;
        grandad2.age = 3;
        grandad2.children = mother;
        Human granny1 = new Human();
        granny1.name = "Granny1";
        granny1.sex = false;
        granny1.age = 3;
        granny1.children = father;
        Human granny2 = new Human();
        granny2.name = "Granny2";
        granny2.sex = false;
        granny2.age = 3;
        granny2.children = mother;
        System.out.println(grandad1);
        System.out.println(granny1);
        System.out.println(grandad2);
        System.out.println(granny2);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList <Human> children;

        /*public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }*/

        public String toString() {
            StringBuilder text = new StringBuilder();
            text.append("Имя: ").append(this.name);
            text.append(", пол: ").append(this.sex ? "мужской" : "женский");
            text.append(", возраст: ").append(this.age);

            int childCount = this.children.size();
            if (childCount > 0) {
                text.append(", дети: ").append(this.children.get(0).name);

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text.append(", ").append(child.name);
                }
            }
            return text.toString();
        }
    }
}
