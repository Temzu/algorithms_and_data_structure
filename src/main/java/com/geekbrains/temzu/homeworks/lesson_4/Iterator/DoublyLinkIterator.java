package com.geekbrains.temzu.homeworks.lesson_4.Iterator;

import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.Node;

public interface DoublyLinkIterator extends SingleLinkIterator {
    Node getPrevious();
    boolean atStart();
    void last();
    void resetToEnd();
}
