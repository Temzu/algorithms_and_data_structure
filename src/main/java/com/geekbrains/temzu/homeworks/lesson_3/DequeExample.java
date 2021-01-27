package com.geekbrains.temzu.homeworks.lesson_3;

public class DequeExample {
    public static void main(String[] args) {
        Deque deque = new Deque(10);
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushLeft(10);
        deque.pushLeft(9);
        deque.pushLeft(8);
        deque.pushLeft(7);
        deque.pushLeft(6);
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
    }
}
