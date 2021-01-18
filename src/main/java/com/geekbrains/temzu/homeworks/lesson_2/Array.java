package com.geekbrains.temzu.homeworks.lesson_2;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = size;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public Array(boolean isSorted, int... args) {
        this(args);
        this.isSorted = isSorted;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
        isSorted = false;
    }

    public boolean delete() { // last
        if (size == 0) return false;
        size--;
        return true;
    }

    public boolean delete(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);

        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    public boolean deleteAll() {
        isSorted = false;
        size = 0;
        return true;
    }

    // Возможно здесь лучше выводить количество удаленных записей
    public boolean deleteAll(int value) {
        boolean del = false;
        if (!isSorted) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    delete(i);
                    del = true;
                }
            }
        } // else {
//            // здесь нужно найти элемент в отсортированном массиве и если он есть, то вернуть левую и правую границу,
//            // а после в цикле удалить эти элемент(ы).
//        }
        return del;
    }

    public void append(int value) {
        checkSize();
        arr[size++] = value;
        isSorted = false;
    }

    public void insert(int index, int value) {
        checkSize();
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    private void checkSize() {
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
    }

    public boolean isInArray(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Trying to search in unsorted array");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1;
            if (value == arr[m]) {
                return m;
            } else {
                if (value < arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() {
        int count = 0;
        for (int out = size - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (this.arr[in] > arr[in + 1]) {
                    swap(in, in + 1);
                    count++;
                }
            }
        }
        System.out.println(count);
        isSorted = true;
    }

    public void sortBubble2() {
        int count = 0;
        boolean flag = true;
        int n = 0;
        int buf;
        int len = this.arr.length;
        while (flag) {
            flag = false;
            for (int i = 0; i < len - 1 - n; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                    count++;
                }
            }
            n++;
        }
        System.out.println(count);
    }

    public void sortSelect() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int flag = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[flag]) {
                    flag = j;
                    count++;
                }
            }
            count++;
            swap(i, flag);
        }
        System.out.println(count);
        isSorted = true;
    }

    public void sortInsert() {
        int count = 0;
        for (int out = 1; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
                count++;
            }
            count++;
            arr[in] = temp;
        }
        System.out.println(count);
        isSorted = true;
    }

    // homework
//        boolean deleteAll(int value) { } // by value
//        boolean deleteAll() { } // clear
//        void insert(int index, int value) { } // shift the tail
//        // improve bubble sort (kinda make it better somehow)

    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
