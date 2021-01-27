package com.geekbrains.temzu.homeworks.lesson_3;

public class Deque {
    private int right;
    private int left;
    private final int capacity;
    private int size;
    private int[] deque;

    public Deque(int capacity) {
        this.right = 0;
        this.left = 1;
        this.size = 0;
        this.capacity = capacity;
        this.deque = new int[capacity];
    }

    public void pushLeft(int value) {
        if (--left < 0)
            left = capacity - 1;
        deque[left] = value;
        size++;
    }

    public void pushRight(int value) {
        if (++right == capacity)
            right = 0;
        deque[right] = value;
        size++;
    }

    public int popLeft() {
        if (left == capacity)
            left = 0;
        size--;
        return deque[left++];
    }

    public int popRight() {
        if (right < 0)
            right = capacity - 1;
        size--;
        return deque[right--];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
