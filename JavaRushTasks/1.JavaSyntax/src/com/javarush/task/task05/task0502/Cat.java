package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int age1 = this.age, age2 = anotherCat.age;
        int weight1 = this.weight, weight2 = anotherCat.weight;
        int strength1 = this.strength, strength2 = anotherCat.strength;
        boolean first_win = false;
        double store = 0;
        if (age1 > age2) {
            store++;
            first_win = true;
        }
        if (age1 == age2) {
            if (weight1 == weight2) {
                if (strength1 == strength2) {
                    System.out.println("Мы в жопе");
                } else {
                    if (strength1 > strength2) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                if (weight1 > weight2) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (weight1 > weight2) {
            store++;
        }
        if (weight1 == weight2){
            store += 0.5;
        }
        if (strength1 > strength2) {
            store++;
        }
        if (strength1 == strength2){
            store += 0.5;
        }
        if(store > 1.5)
        {
            return true;
        }
        if (store < 1.5)
        {
            return false;
        }
        if(first_win)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
