package com.geekbrains.temzu.homeworks.lesson_4.LinkedList;


import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.Iterator.SingleIter;

public class SingleLinkedList implements LinkedList {
    protected Node head;

    public SingleLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public void push(Cat c) {
        Node n = new Node(c);
        n.setNext(head);
        head = n;
    }
    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.getCat();
        head = head.getNext();
        return temp;
    }
    public boolean contains(Cat c) {
        Node n = new Node(c);
        Node current = head;
        while (!current.equals(n)) {
            if (current.getNext() == null) return false;
            else current = current.getNext();
        }
        return true;
    }
    public void delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = null;
        while (!current.equals(n)) {
            if (current.getNext() == null) return;
            else {
                previous = current;
                current = current.getNext();
            }
        }

        if (current == head) {
            head = head.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SingleIter getIterator() {
        return new SingleIter(this);
    }
}
