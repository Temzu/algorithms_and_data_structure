package com.geekbrains.temzu.homeworks.lesson_4.LinkedList;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.Iterator.DoublyIter;

public class DoublyLinkedList extends SingleLinkedList implements LinkedList {
    private Node tail;

    public DoublyLinkedList() {
        super();
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && tail == null;
    }

    public void pushStart(Cat cat) {
        Node node = new Node(cat);
        node.setNext(head);
        if (head == null) {
            head = node;
            if (tail == null)
                tail = head;
            return;
        }
        head.setPrevious(node);
        head = node;
    }

    public void pushEnd(Cat cat) {
        Node node = new Node(cat);
        node.setPrevious(tail);
        if (tail == null) {
            tail = node;
            if (head == null)
                head = tail;
            return;
        }
        tail.setNext(node);
        tail = node;
    }

    public Cat takeStart() {
        if (isEmpty()) return null;
        Cat temp = head.getCat();
        if (head == null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            if (head == null) {
                tail = null;
                return temp;
            }
            head.setPrevious(null);
        }
        return temp;
    }

    public Cat takeEnd() {
        if (isEmpty()) return null;
        Cat temp = tail.getCat();
        if (tail == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            if (tail == null) {
                head = null;
                return temp;
            }
            tail.setNext(null);
        }
        return temp;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public DoublyIter getIterator() {
        return new DoublyIter(this);
    }

}
