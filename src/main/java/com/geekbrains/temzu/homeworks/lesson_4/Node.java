package com.geekbrains.temzu.homeworks.lesson_4;

import java.util.Objects;

public class Node {
    Cat c;
    Node next;
    public Node(Cat c) {
        this.c = c;
    }
    @Override
    public String toString() {
        return String.format("Node(c=%s)", c);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(c, node.c) &&
                Objects.equals(next, node.next);
    }
}
