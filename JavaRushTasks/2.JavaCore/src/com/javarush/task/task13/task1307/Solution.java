package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject implements SimpleObject<String> {
        @Override
        public StringObject getInstance() {
            return null;
        }
    }
}