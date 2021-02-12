package com.geekbrains.temzu.homeworks.lesson_8;

public class HashCat {

    private Item[] hashArray;
    private int arraySize;
    private static Item nullItem = new Item(-1);

    public HashCat(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new Item[arraySize];
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }
    public void insert(Item item) {
        int key = item.getData();
        int hashVal = hashFunc(key);
        int step = doubleHashFunc(key);
        if (isFull()) increaseCapacity();
        while(hashArray[hashVal] != null && hashArray[hashVal] != nullItem) {
            //hashVal = linearProbe(hashVal);
            //hashVal = quadProbe(hashVal, ++step);
            hashVal += step;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        int starVal = hashVal;
        int step = doubleHashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == key)
                return hashArray[hashVal];
            hashVal += step;
            hashVal %= arraySize;
            // hashVal = linearProbe(hashVal);
            // hashVal = quadProbe(hashVal, ++step);
            if (starVal == hashVal) return null;
        }
        return null;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        int step = doubleHashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = nullItem;
                return temp;
            }
            //hashVal = linearProbe(hashVal);
            //hashVal = quadProbe(hashVal, ++step);
            hashVal += step;
            hashVal %= arraySize;
        }
        return null;
    }

    private boolean isFull() {
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] == null || hashArray[i] == nullItem)
                return false;
        }
        return true;
    }

    private void increaseCapacity() {
        arraySize *= 2;
        Item[] oldArr = hashArray;
        hashArray = new Item[arraySize];
        for (Item item : oldArr)
            insert(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            sb.append(hashArray[i] != null ? hashArray[i].getData() : "*");
            if (i != arraySize - 1)
                sb.append(", ");
        }
        return sb.toString();
    }

    // linear probe
    private int linearProbe(int hashVal) {
        hashVal++;
        hashVal %= arraySize;
        return hashVal;
    }

    // quad probe
    private int quadProbe(int hashVal, int step) {
        hashVal += step * step;
        hashVal %= arraySize;
        return hashVal;
    }

    // double hash
    // shift = const - (key % const)
    private int doubleHashFunc(int key) {
        return 11 - (key % 11);
    }
}
