package com.mycompany.basiccollections;

import java.util.*;

public class MapCompare {
    static final int collectionSize = 100_000;
    static final int nano = 1_000_000_000;

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        Random random = new Random();


        double hashAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashMap.put(i, i);
        }
        double hashAddEnd = System.nanoTime();

        double linkAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashMap.put(i, i);
        }
        double linkAddEnd = System.nanoTime();

        double treeAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.put(i, i);
        }
        double treeAddEnd = System.nanoTime();

        double hashGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashMap.containsKey(random.nextInt(hashMap.size()));
        }
        double hashGetEnd = System.nanoTime();

        double linkGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashMap.containsKey(random.nextInt(linkedHashMap.size()));
        }
        double linkGetEnd = System.nanoTime();

        double treeGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.containsKey(random.nextInt(treeMap.size()));
        }
        double treeGetEnd = System.nanoTime();

        double hashRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashMap.remove(random.nextInt(hashMap.size()));
        }
        double hashRemEnd = System.nanoTime();

        double linkRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashMap.remove(random.nextInt(linkedHashMap.size()));
        }
        double linkRemEnd = System.nanoTime();

        double treeRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.remove(random.nextInt(treeMap.size()));
        }
        double treeRemEnd = System.nanoTime();

        System.out.println("Put, HashMap: " + (hashAddEnd - hashAddStart) / nano
                + " LinkedHashMap: " + (linkAddEnd - linkAddStart) / nano
                + " TreeMap: " + (treeAddEnd - treeAddStart) / nano );
        System.out.println("Contains, HashMap: " + (hashGetEnd - hashGetStart) / nano
                + " LinkedHashMap: " + (linkGetEnd - linkGetStart) / nano
                + " TreeMap: " + (treeGetEnd - treeGetStart) / nano );
        System.out.println("Remove, HashMap: " + (hashRemEnd - hashRemStart) / nano
                + " LinkedHashMap: " + (linkRemEnd - linkRemStart) / nano
                + " TreeMap: " + (treeRemEnd - treeRemStart) / nano);
    }
}
