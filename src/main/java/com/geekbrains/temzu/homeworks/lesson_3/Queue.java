package com.geekbrains.temzu.homeworks.lesson_3;

public class Queue {
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;

    public Queue(int initial) {
        queue = new int[initial];
        head = 0;
        tail = -1;
        capacity = 0;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean isFull() {
        return capacity == queue.length;
    }

    public int length() {
        return capacity;
    }

    public void insert(int i) {
        if (isFull())
            throw new RuntimeException("Queue is full!");
        if (tail == queue.length -1)
            tail = -1;
        queue[++tail] = i;
        capacity++;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= queue.length; //if (head == queue.length) head = 0;
        capacity--;
        return temp;
    }

}

