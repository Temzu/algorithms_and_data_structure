package com.geekbrains.temzu.homeworks.lesson_5;

public class Main {
    //Рекурсия
//    1. Написать программу по возведению числа в степень с помощью рекурсии.
//    2. * Задача о шахматном короле
//    3. * Задача о восьми ферзях


    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

    public static int pow(int a, int pow) {
        if (pow == 1) {
            return a;
        } else {
            return a * pow(a, --pow);
        }
    }
}
