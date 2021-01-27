package com.geekbrains.temzu.homeworks.lesson_4.Iterator;

import com.geekbrains.temzu.homeworks.lesson_4.Cat;
import com.geekbrains.temzu.homeworks.lesson_4.Node;

public interface SingleLinkIterator {
    void reset();
    void next();
    Node getCurrent();
    boolean atEnd();
    void insertBefore(Cat cat);
    void insertAfter(Cat cat);
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
