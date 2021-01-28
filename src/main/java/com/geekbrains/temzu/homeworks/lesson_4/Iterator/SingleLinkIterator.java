package com.geekbrains.temzu.homeworks.lesson_4.Iterator;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.LinkedList.Node;

public interface SingleLinkIterator {
    void resetToStart();
    void next();
    Node getCurrent();
    boolean atEnd();
    boolean insertBefore(Cat cat);
    boolean insertAfter(Cat cat);
    Cat deleteCurrent();
// class iteroCat
    // reset()
    // next(), prev(for dll)
    // getCurrent()
    // atEnd()
    // insertBefore();
    // insertAfter();
    // deleteCurrent();

}
