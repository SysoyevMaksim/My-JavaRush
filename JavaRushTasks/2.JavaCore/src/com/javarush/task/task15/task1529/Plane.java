package com.javarush.task.task15.task1529;

public class Plane implements CanFly{
    @Override
    public void fly() {

    }

    int passengers;

    public Plane(int passengers){
        this.passengers = passengers;
    }
}
