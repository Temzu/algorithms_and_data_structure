package com.geekbrains.temzu.homeworks.lesson_4.Iterator;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.LinkedList;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.Node;

public class SingleIter implements SingleLinkIterator {
    protected Node current;
    protected Node previous;
    protected LinkedList linkedList;

    public SingleIter(LinkedList linkedList) {
        this.linkedList = linkedList;
        this.current = linkedList.getHead();
        this.previous = null;
    }

    @Override
    public void resetToStart() {
        current = linkedList.getHead();
        previous = null;
    }

    @Override
    public void next() {
        if (atEnd())
            throw new RuntimeException("You have reached the end of the linked list!");
        previous = current;
        current = current.getNext();
    }

    @Override
    public Node getCurrent() {
        return current;
    }

    @Override
    public boolean atEnd() {
        return current.getNext() == null;
    }

    @Override
    public boolean insertBefore(Cat cat) {
        Node node = new Node(cat);
        if (previous == null) {
            node.setNext(linkedList.getHead());
            linkedList.setHead(node);
            resetToStart();
            return false;
        } else {
            node.setNext(previous.getNext());
            previous.setNext(node);
            current = node;
            return true;
        }
    }

    @Override
    public boolean insertAfter(Cat cat) {
        Node node = new Node(cat);
        if (linkedList.isEmpty()) {
            linkedList.setHead(node);
            current = node;
            return false;
        } else {
            node.setNext(current.getNext());
            current.setNext(node);
            next();
            return true;
        }
    }

    @Override
    public Cat deleteCurrent() {
        Cat cat = current.getCat();
        if (previous == null) {
            linkedList.setHead(current.getNext());
            current = null;
            resetToStart();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()) {
                current = previous;
                previous = previous.getPrevious();
            } else {
                current = current.getNext();
            }
        }
        return cat;
    }
}
