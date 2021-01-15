package com.mycompany.basiccollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedList {

    static final int collectionSize = 100_000;
    static final int nano = 1_000_000_000;

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        System.out.println("Add elements, ArrayList: " + addTime(arrayList)
                + " LinkedList: " + addTime(linkedList));

        System.out.println("Get elements from begin, ArrayList: " + searchTime(arrayList, 1)
                + " LinkedList: " + searchTime(linkedList, 1));

        System.out.println("Get elements from middle, ArrayList: " + searchTime(arrayList, collectionSize / 2)
                + " LinkedList: " + searchTime(linkedList, collectionSize / 2));

        System.out.println("Get elements from end, ArrayList: " + searchTime(arrayList, collectionSize - 1)
                + " LinkedList: " + searchTime(linkedList, collectionSize - 1));

        System.out.println("Insert elements to begin, ArrayList: " + insertTimeBegin(arrayList)
                + " LinkedList: " + insertTimeBegin(linkedList));

        System.out.println("Remove elements from begin, ArrayList: " + removeTimeBegin(arrayList)
                + " LinkedList: " + removeTimeBegin(linkedList));

        System.out.println("Insert elements to middle, ArrayList: " + insertTime(arrayList, 2)
                + " LinkedList: " + insertTime(linkedList, 2));

        System.out.println("Remove elements from middle, ArrayList: " + removeTime(arrayList, 2)
                + " LinkedList: " + removeTime(linkedList, 2));

        System.out.println("Insert elements to end, ArrayList: " + insertTime(arrayList, 1)
                + " LinkedList: " + insertTime(linkedList, 1));

        System.out.println("Remove elements from end, ArrayList: " + removeTime(arrayList, 1)
                + " LinkedList: " + removeTime(linkedList, 1));
    }

    static double addTime(List list) {
        double start = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            list.add("new element " + i);
        }
        double finish = System.nanoTime();
        return (finish - start) / nano;
    }

    static double searchTime(List list, int index) {
        double start = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            list.get(index);
        }
        double finish = System.nanoTime();
        return (finish - start) / nano;
    }

    static double insertTimeBegin(List list) {
        double start = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            list.add(0, "new element" + i);
        }
        double finish = System.nanoTime();
        return (finish - start) / nano;
    }

    static double insertTime(List list, int coef) {
        double start = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            list.add(list.size() / coef - 1, "new element" + i);
        }
        double finish = System.nanoTime();
        return (finish - start) / nano;
    }

    static double removeTimeBegin(List list) {
        double start = System.nanoTime();
        while (list.size() > collectionSize) {
            list.remove(0);
        }
        double finish = System.nanoTime();

        return (finish - start) / nano;
    }

    static double removeTime(List list, int coef) {
        double start = System.nanoTime();
        while (list.size() > collectionSize) {
            list.remove(list.size() / coef - 1);
        }
        double finish = System.nanoTime();

        return (finish - start) / nano;
    }
}
