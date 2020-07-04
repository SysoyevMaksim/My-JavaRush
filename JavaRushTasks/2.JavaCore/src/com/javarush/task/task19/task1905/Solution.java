package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String country = customer.getCountryName();
            for (HashMap.Entry<String, String> pair : countries.entrySet()){
                if (pair.getValue().equals(country)){
                    return pair.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().indexOf(',') + 2);
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().indexOf(','));
        }

        @Override
        public String getDialString() {
            String s = contact.getPhoneNumber();
            String s1 = s.substring(s.indexOf('+') + 1, s.indexOf('(')) +
                    s.substring(s.indexOf('(') + 1, s.indexOf(')')) +
                    s.substring(s.indexOf(')') + 1, s.indexOf('-'));
            int i1 = s.indexOf('-');
            int i2 = s.lastIndexOf('-');
            if (i1 == i2){
                s1 += s.substring(i2 + 1);
            } else {
                s1 += s.substring(i1 + 1, i2);
                s1 += s.substring(i2 + 1);
            }
            return "callto://+" + s1;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}