package com.geekbrains.temzu.homeworks.lesson_1;

public class homework {
    public static void main(String[] args) {
        System.out.println(elevate(2,-3));


        int[] arr = {6,2,3,1,10,8};
        System.out.println(searchMinEl(arr));

        System.out.println(findAvg(arr));

    }

    // O(n) - линейный поиск
    public static double elevate(int number, int degree) {
        double result = 1.0;
        int absDegree = Math.abs(degree);
        if (degree == 0)
            return result;
        for (int i = 0; i < absDegree; i++) {
            result *= number;
        }
        if (degree < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

    // O(n) - линейный поиск, если бы подавался отсортированный массив, то можно было бы использовать первый элемент массива.
    // Если сортировку делать в отдельном методе, то в это займет O(n^2) или в у лучшем случае O(n * log(n))
    public static int searchMinEl(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    // O - линейный поиск
    public static double findAvg(int[] arr) {
        double sum = 0.0;
        int lenArr = arr.length;
        for (int i = 0; i < lenArr; i++) {
            sum += arr[i];
        }
        return sum / lenArr;
    }







}
