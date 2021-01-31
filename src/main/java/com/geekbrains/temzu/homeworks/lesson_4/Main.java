package com.geekbrains.temzu.homeworks.lesson_4;

import com.geekbrains.temzu.homeworks.lesson_4.Iterator.DoublyIter;
import com.geekbrains.temzu.homeworks.lesson_4.Iterator.SingleIter;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.DoublyLinkedList;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.SingleLinkedList;


public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(new Cat(1111, "sdfdd"));
        singleLinkedList.push(new Cat(2222," sdfsd"));
        singleLinkedList.push(new Cat(3333," sdfsd"));
        SingleIter iterator1 = singleLinkedList.getIterator();
        while (iterator1.getCurrent() != null) {
            System.out.println(iterator1.deleteCurrent());
        }

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.pushStart(new Cat(1111, "sdfdd"));
        linkedList.pushEnd(new Cat(2222," sdfsd"));
        linkedList.pushEnd(new Cat(3333," sdfsd"));
        DoublyIter iterator = linkedList.getIterator();
        iterator.insertBefore(new Cat(123,"Usdf"));
        while (iterator.getCurrent() != null) {
            System.out.println(iterator.deleteCurrent());
        }


    }
}
