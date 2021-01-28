package com.geekbrains.temzu.homeworks.lesson_4.LinkedList;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;

import java.util.Objects;

public class Node {
    private Cat cat;
    private Node next;
    private Node previous;
    public Node(Cat c) {
        this.cat = c;
    }
    @Override
    public String toString() {
        return String.format("Node(c=%s)", cat);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(cat, node.cat) &&
                Objects.equals(next, node.next);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
