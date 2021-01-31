package com.geekbrains.temzu.homeworks.lesson_4.Iterator;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.Node;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.SingleLinkedList;

public class DoublyIter extends SingleIter implements DoublyLinkIterator{
    public DoublyIter(SingleLinkedList linkedList) {
        super(linkedList);
    }

    @Override
    public boolean insertBefore(Cat cat) {
        if (super.insertBefore(cat)) {
            current.setPrevious(previous);
            current.getNext().setPrevious(current);
            return true;
        } else {
            current.getNext().setPrevious(current);
        }
        return false;
    }

    @Override
    public boolean insertAfter(Cat cat) {
        if (super.insertAfter(cat)) {
            current.getNext().setPrevious(current);
            current.setPrevious(previous);
            return true;
        }
        return false;
    }

    @Override
    public Node getPrevious() {
        return previous;
    }

    @Override
    public boolean atStart() {
        return current == null;
    }

    @Override
    public boolean atEnd() {
        return current == null;
    }

    @Override
    public void last() {
        if (atStart())
            throw new RuntimeException("You have reached the start of the linked list!");
        current = previous;
        if (previous != null)
            previous = previous.getPrevious();

    }

    @Override
    public void resetToEnd() {
        current = linkedList.getTail();
        previous = current.getPrevious();
    }


}
