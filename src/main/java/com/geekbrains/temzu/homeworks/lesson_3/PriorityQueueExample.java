package com.geekbrains.temzu.homeworks.lesson_3;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(20);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(123);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.insert(13);
        queue.insert(14);
        queue.insert(15);
        queue.insert(16);
        queue.insert(17);
        queue.insert(18);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
