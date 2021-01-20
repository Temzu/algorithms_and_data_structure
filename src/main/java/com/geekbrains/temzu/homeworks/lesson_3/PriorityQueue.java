package com.geekbrains.temzu.homeworks.lesson_3;

public class PriorityQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;

    public PriorityQueue(int initial) {
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

    public void insert(int value) {
        if (isFull())
            throw new RuntimeException("Queue is full!");
        if (tail == queue.length -1)
            tail = -1;
        if (capacity == 0) {
            queue[++tail] = value;
        } else {
            int buff = 0;
            // В данном варианте наибольший приоритет имеет наибольший int
            for (int i = capacity - 1; i >= 0; i--) {
                if (value > queue[i]) {
                    queue[i + 1] = queue[i];
                    buff = i - 1;
                } else {
                    buff = i;
                    break;
                }
            }
            queue[buff + 1] = value;
        }
        capacity++;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= queue.length;
        capacity--;
        return temp;
    }

}
