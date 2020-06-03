package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height)
    {
        this.top = top;
        this.left= left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left, int width)
    {
        this.top = top;
        this.left= left;
        this.width = width;
        this.height = this.width;
    }

    public Rectangle(int top, int left)
    {
        this.top = top;
        this.left= left;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(Rectangle it)
    {
        this.top = it.top;
        this.left= it.left;
        this.width = it.width;
        this.height = it.height;
    }

    public static void main(String[] args) {

    }
}
