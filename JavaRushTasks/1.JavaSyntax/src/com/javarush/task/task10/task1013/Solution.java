package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int one;
        private int two;
        private int three;
        private int four;
        private int five;
        private String six;

        public Human(int one){
            this.one = one;
        }

        public Human(int one, int two){
            this.one = one;
            this.two = two;
        }

        public Human(int one, int two, int three){
            this.one = one;
            this.two = two;
            this.three = three;
        }

        public Human(int one, int two, int three, int four){
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
        }

        public Human(int one, int two, int three, int four, int five){
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
            this.five = five;
        }

        public Human(int one, int two, int three, int four, int five, String six){
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
            this.five = five;
            this.six = six;
        }

        public Human(int one, int two, int three, int four, String six){
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
            this.six = six;
        }

        public Human(int one, int two, int three, String six){
            this.one = one;
            this.two = two;
            this.three = three;
            this.six = six;
        }

        public Human(int one, int two, String six){
            this.one = one;
            this.two = two;
            this.six = six;
        }

        public Human(int one, String six){
            this.one = one;
            this.six = six;
        }
    }
}
