package com.geekbrains.temzu.homeworks.lesson_4;


import com.geekbrains.temzu.homeworks.lesson_4.Iterator.SingleLinkIterator;

public class SingleLinkedList {
    private Node head;
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

    public SingleIter getIterator() {
        return new SingleIter(this);
    }

    private class SingleIter implements SingleLinkIterator {
        private Node current;
        private Node previous;
        private SingleLinkedList linkedList;

        public SingleIter(SingleLinkedList linkedList) {
            this.linkedList = linkedList;
            this.current = linkedList.head;
            this.previous = null;
        }

        @Override
        public void reset() {
            this.current = linkedList.head;
            this.previous = null;
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
        public void insertBefore(Cat cat) {
            Node node = new Node(cat);
            if (previous == null) {
                node.setNext(linkedList.head);
                linkedList.head = node;
                reset();
            } else {
                node.setNext(previous.getNext());
                previous.setNext(node);
                current = node;
            }
        }

        @Override
        public void insertAfter(Cat cat) {
            Node node = new Node(cat);
            if (linkedList.isEmpty()) {
                linkedList.head = node;
                current = node;
            } else {
                node.setNext(current.getNext());
                current.setNext(node);
                next();
            }
        }

        @Override
        public Cat deleteCurrent() {
            Cat cat = current.getCat();
            if (previous == null) {
                linkedList.head = current.getNext();
                current = null;
                reset();
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
}
