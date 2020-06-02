package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public void initialize(int top, int left, int width, int height)
    {
        this.top = top;
        this.left= left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int left, int width)
    {
        this.top = top;
        this.left= left;
        this.width = width;
        this.height = this.width;
    }

    public void initialize(int top, int left)
    {
        this.top = top;
        this.left= left;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(Rectangle it)
    {
        this.top = it.top;
        this.left= it.left;
        this.width = it.width;
        this.height = it.height;
    }

    public static void main(String[] args) {

    }
}
