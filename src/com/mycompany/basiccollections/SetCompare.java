package com.mycompany.basiccollections;

import java.util.*;

public class SetCompare {
    static final int collectionSize = 100_000;
    static final int nano = 1_000_000_000;

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Random random = new Random();

        double hashAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashSet.add(i);
        }
        double hashAddEnd = System.nanoTime();

        double linkAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashSet.add(i);
        }
        double linkAddEnd = System.nanoTime();

        double treeAddStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeSet.add(i);
        }
        double treeAddEnd = System.nanoTime();

        double hashGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashSet.contains(random.nextInt(hashSet.size()));
        }
        double hashGetEnd = System.nanoTime();

        double linkGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashSet.contains(random.nextInt(linkedHashSet.size()));
        }
        double linkGetEnd = System.nanoTime();

        double treeGetStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeSet.contains(random.nextInt(treeSet.size()));
        }
        double treeGetEnd = System.nanoTime();

        double hashRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            hashSet.remove(random.nextInt(hashSet.size()));
        }
        double hashRemEnd = System.nanoTime();

        double linkRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            linkedHashSet.remove(random.nextInt(linkedHashSet.size()));
        }
        double linkRemEnd = System.nanoTime();

        double treeRemStart = System.nanoTime();
        for (int i = 0; i < collectionSize; i++) {
            treeSet.remove(random.nextInt(treeSet.size()));
        }
        double treeRemEnd = System.nanoTime();

        System.out.println("Add, HashSet: " + (hashAddEnd - hashAddStart) / nano
                + " LinkedHashSet: " + (linkAddEnd - linkAddStart) / nano
                + " TreeSet: " + (treeAddEnd - treeAddStart) / nano );
        System.out.println("Contains, HashSet: " + (hashGetEnd - hashGetStart) / nano
                + " LinkedHashSet: " + (linkGetEnd - linkGetStart) / nano
                + " TreeSet: " + (treeGetEnd - treeGetStart) / nano );
        System.out.println("Remove, HashSet: " + (hashRemEnd - hashRemStart) / nano
                + " LinkedHashSet: " + (linkRemEnd - linkRemStart) / nano
                + " TreeSet: " + (treeRemEnd - treeRemStart) / nano);
    }

}
