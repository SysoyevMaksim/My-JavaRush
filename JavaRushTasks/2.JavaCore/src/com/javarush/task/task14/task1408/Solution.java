package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
//        System.out.println(hen.getDescription());
//        if (hen.getDescription().equals("Я - курица. Моя страна - Ukraine. Я несу 2 яиц в месяц.")){
//            System.out.println("Они дураки");
//        }
    }

    static class HenFactory implements Country{

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country.equals(BELARUS)){
                hen = new BelarusianHen();
            } else if (country.equals(RUSSIA)) {
                hen = new RussianHen();
            } else if (country.equals(MOLDOVA)){
                hen = new MoldovanHen();
            } else if (country.equals(UKRAINE)){
                hen = new UkrainianHen();
            }
            return hen;
        }
    }

}
