package com.geekbrains.temzu.homeworks.lesson_7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('i');
        graph.addVertex('j');

        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(4, 8);
        graph.addEdge(4, 1);
        graph.addEdge(4, 7);
        graph.addEdge(8, 9);
        graph.addEdge(9, 6);
        graph.addEdge(6, 5);
        graph.addEdge(1, 6);
        graph.addEdge(1, 3);

        List<Character> list = graph.findShortestWay('c', 'g');
        System.out.println(list);
    }
}
