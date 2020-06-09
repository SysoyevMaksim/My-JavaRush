package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
//        System.out.println(isDateOdd("JANUARY 1 2000"));
//        System.out.println(isDateOdd("JANUARY 2 2020"));
//        System.out.println(isDateOdd("JANUARY 3 2020"));
//        System.out.println(isDateOdd("JANUARY 4 2020"));
//        System.out.println(isDateOdd("JANUARY 5 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Date date1 = formatter.parse(date);
        boolean a = (date1.getYear() + 1900) % 4 == 0;
        boolean b = (date1.getYear() + 1900) % 100 == 0;
        boolean c = (date1.getYear() + 1900) % 400 == 0;
        int nomber = 0;
        if(date1.getMonth() == Calendar.FEBRUARY){
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.MARCH){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.APRIL){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.MAY){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
        }
        if(date1.getMonth() == Calendar.JUNE){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.JULY){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
        }
        if(date1.getMonth() == Calendar.AUGUST){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.SEPTEMBER){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.OCTOBER){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 31;
            nomber += 30;
        }
        if(date1.getMonth() == Calendar.NOVEMBER){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
        }
        if(date1.getMonth() == Calendar.DECEMBER){
            if(a && (!b || c)){
                nomber += 29;
            }
            else {
                nomber += 28;
            }
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 31;
            nomber += 30;
            nomber += 31;
            nomber += 30;
        }
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        cal.setTime(date1);
        //System.out.println(cal.get(Calendar.DAY_OF_MONTH) + " " + date1.getMonth() + " " + date1.getYear());
        nomber += cal.get(Calendar.DAY_OF_MONTH);
        return nomber % 2 == 1;
    }
}
