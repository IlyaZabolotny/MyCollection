package com.mycompany.basiccollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedList {

    static final int collectionSize = 100_000;
    static final int nano = 1_000_000_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        double arrAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.add(i);
        }
        double arrAddEnd = System.nanoTime();

        double linkAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedList.add(i);
        }
        double linkAddEnd = System.nanoTime();

        double arrGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.get(random.nextInt(arrayList.size()));
        }
        double arrGetEnd = System.nanoTime();

        double linkGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedList.get(random.nextInt(arrayList.size()));
        }
        double linkGetEnd = System.nanoTime();

        double arrRemStart = System.nanoTime();
        while (arrayList.size() > 0) {
            arrayList.remove(random.nextInt(arrayList.size()));
        }
        double arrRemEnd = System.nanoTime();

        double linkRemStart = System.nanoTime();
        while (arrayList.size() > 0) {
            linkedList.remove(random.nextInt(arrayList.size()));
        }
        double linkRemEnd = System.nanoTime();

        System.out.println("Add, ArrayList: " + (arrAddEnd - arrAddStart) / nano
                + " LinkedList: " + (linkAddEnd - linkAddStart) / nano);
        System.out.println("Get, ArrayList: " + (arrGetEnd - arrGetStart) / nano
                + " LinkedList: " + (linkGetEnd - linkGetStart) / nano);
        System.out.println("Remove, ArrayList: " + (arrRemEnd - arrRemStart) / nano
                + " LinkedList: " + (linkRemEnd - linkRemStart) / nano);
    }
}
