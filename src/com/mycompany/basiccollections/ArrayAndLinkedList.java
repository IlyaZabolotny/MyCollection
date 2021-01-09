package com.mycompany.basiccollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        double arrAddStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        double arrAddEnd = System.nanoTime();

        double linkAddStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        double linkAddEnd = System.nanoTime();

        double arrGetStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(random.nextInt(arrayList.size()));
        }
        double arrGetEnd = System.nanoTime();

        double linkGetStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
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

        System.out.println("Add, ArrayList: " + (arrAddEnd - arrAddStart) / 1_000_000_000
                + " LinkedList: " + (linkAddEnd - linkAddStart) / 1_000_000_000);
        System.out.println("Get, ArrayList: " + (arrGetEnd - arrGetStart) / 1_000_000_000
                + " LinkedList: " + (linkGetEnd - linkGetStart) / 1_000_000_000);
        System.out.println("Remove, ArrayList: " + (arrRemEnd - arrRemStart) / 1_000_000_000
                + " LinkedList: " + (linkRemEnd - linkRemStart) / 1_000_000_000);
    }
}
