package com.geekbrains.temzu.homeworks.lesson_2;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(1,2,3,4,5,6,7);
        System.out.println(array);
        array.insert(2, 100);
        System.out.println(array);
        array.deleteAll(4);
        System.out.println(array);
        array.deleteAll();
        System.out.println(array);

        Array arr = new Array(4,6,7,2,34,24,627,42,1,2,5,6,2,1,3,23,23,4,5,2,3,5,2,2,3,4,5,6,34,
                7,56,8,58,56,45,457,45,8,45,6,745,6,45,6,456,47,8,9,0,4,45,4,3,5,3,5,3,1,2,6,4,3,2,2,6,7,
                8,4,3,23,4,5,7,8,53,2,5,6,23,13,123,5,61,123,142,5,12,3,51,123,112,144123,43,2,1,2,444,5,1,0,23,
                523,6,2,4,5,21,3,5,7,8,95,56,8,59,65,956,956,43,46,7,83,42,5,45,37,8,458,4,3);
        System.out.println(arr);
        //arr.sortInsert(); количество проходов 3894
        //arr.sortBubble(); количество проходов 3362
        //arr.sortSelect(); количество проходов 451 (возможно не правильно счетчик сделал)
        System.out.println(arr);
    }
}
