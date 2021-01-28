package com.geekbrains.temzu.homeworks.lesson_4.LinkedList;

public interface LinkedList {
    Node getHead();
    void setHead(Node node);
    boolean isEmpty();
    default Node getTail() {
        return null;
    }
    default void setTail(Node node){}
}
