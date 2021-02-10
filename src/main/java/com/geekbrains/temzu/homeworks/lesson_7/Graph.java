package com.geekbrains.temzu.homeworks.lesson_7;

import com.geekbrains.temzu.homeworks.lesson_3.Queue;
import com.geekbrains.temzu.homeworks.lesson_3.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Graph {
    private class Vertex {
        char label;
        boolean wasVisited;
        private Vertex previousVertex;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        public Vertex getPreviousVertex() {
            return previousVertex;
        }

        public void setPreviousVertex(Vertex previousVertex) {
            this.previousVertex = previousVertex;
        }

        @Override
        public String toString() {
            return String.format("V=%c", label);
        }
    }

    private final int MAX_VERTICES = 16;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int currentSize;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        currentSize = 0;
    }
    public void addVertex(char label) {
        vertexList[currentSize++] = new Vertex(label);
    }
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1; // change 1 to weight for weight
        adjacencyMatrix[end][start] = 1; // delete this for direction
    }
    public void displayVertex(int v) {
        System.out.print(vertexList[v] + " ");
    }
    private int getUnvisitedVertex(int current) {
        for (int i = 0; i < currentSize; i++) {
            if (adjacencyMatrix[current][i] == 1 &&
                    !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }
    public void depthTraverse() {
        Stack stack = new Stack(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }
    public void widthTraverse() {
        Queue queue = new Queue(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        queue.insert(0);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            displayVertex(current);
            int next;
            while ((next = getUnvisitedVertex(current)) != -1) {
                vertexList[next].wasVisited = true;
                queue.insert(next);
            }
        }
        resetFlags();
    }
    private void resetFlags() {
        for (int i = 0; i < currentSize; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    private void visitVertex(int vertexIndex, Queue queue) {
        queue.insert(vertexIndex);
        vertexList[vertexIndex].wasVisited = true;
    }

    public List<Character> findShortestWay(char start, char finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);
        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Vertex not found: StartIndex = " + startIndex + " FinishIndex = " + finishIndex);
        }
        Queue queue = new Queue(MAX_VERTICES);
        visitVertex(startIndex, queue);
        int currentVertex;
        while (!queue.isEmpty()) {
            currentVertex = getUnvisitedVertex(queue.peak());
            if (currentVertex == -1) {
                queue.remove();
            } else {
                visitVertex(currentVertex, queue);
                vertexList[currentVertex].setPreviousVertex(vertexList[queue.peak()]);
                if (vertexList[currentVertex].label == finish) {
                    List<Character> list = new ArrayList<>();
                    Vertex vertex = vertexList[currentVertex];
                    while (vertex != null) {
                        list.add(vertex.label);
                        vertex = vertex.getPreviousVertex();
                    }
                    Collections.reverse(list);
                    return list;
                }
            }
        }
        return null;
    }

    private int indexOf(char el) {
        for (int i = 0; i < currentSize; i++) {
            if (vertexList[i].label == el) {
                return i;
            }
        }
        return -1;
    }

}
