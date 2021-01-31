package com.geekbrains.temzu.homeworks.lesson_5;


public class Main {
    //Рекурсия
//    1. Написать программу по возведению числа в степень с помощью рекурсии.
//    2. * Задача о шахматном короле

    private static int move = 1;
    private static int[][] desk = new int[8][8];

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
        System.out.println();




        //3432 вариантов
        king(desk, 8);
        System.out.println("move = " + move);

        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length; j++) {
                System.out.printf("%5d", desk[i][j]);
            }
            System.out.println();
        }


    }

    private static void step() {
        move++;
    }

    private static void king(int[][] desk, int bound) {
        int tmp = 1;
        if (bound == 0) {
            step();
        } else {
            king(desk, --bound);
            for (int y = bound; y < desk.length; y++) {
                for (int x = bound; x < desk[y].length; x++) {
                    if (x == 0 || y == 0) {
                        desk[y][x] = 1;
                    } else {
                        tmp = move;
                        desk[y][x] = desk[y][x - 1] + desk[y - 1][x];
                    }
                }
            }
            move += tmp;
        }
    }

    private static int pow(int a, int pow) {
        if (pow == 1) {
            return a;
        } else {
            return a * pow(a, --pow);
        }
    }
}
