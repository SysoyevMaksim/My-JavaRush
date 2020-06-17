package com.javarush.task.task14.task1421;

public class Singleton {
    static private final Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }

    private Singleton(){

    }
}
