package com.mycompany.basiccollections;

import java.util.*;

public class SetCompare {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Random random = new Random();

        double hashAddStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(i);
        }
        double hashAddEnd = System.nanoTime();

        double linkAddStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.add(i);
        }
        double linkAddEnd = System.nanoTime();

        double treeAddStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(i);
        }
        double treeAddEnd = System.nanoTime();

        double hashGetStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.contains(random.nextInt(hashSet.size()));
        }
        double hashGetEnd = System.nanoTime();

        double linkGetStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.contains(random.nextInt(linkedHashSet.size()));
        }
        double linkGetEnd = System.nanoTime();

        double treeGetStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.contains(random.nextInt(treeSet.size()));
        }
        double treeGetEnd = System.nanoTime();

        double hashRemStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.remove(random.nextInt(hashSet.size()));
        }
        double hashRemEnd = System.nanoTime();

        double linkRemStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.remove(random.nextInt(linkedHashSet.size()));
        }
        double linkRemEnd = System.nanoTime();

        double treeRemStart = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.remove(random.nextInt(treeSet.size()));
        }
        double treeRemEnd = System.nanoTime();

        System.out.println("Add, HashSet: " + (hashAddEnd - hashAddStart) / 1_000_000_000
                + " LinkedHashSet: " + (linkAddEnd - linkAddStart) / 1_000_000_000
                + " TreeSet: " + (treeAddEnd - treeAddStart) / 1_000_000_000 );
        System.out.println("Get, HashSet: " + (hashGetEnd - hashGetStart) / 1_000_000_000
                + " LinkedHashSet: " + (linkGetEnd - linkGetStart) / 1_000_000_000
                + " TreeSet: " + (treeGetEnd - treeGetStart) / 1_000_000_000 );
        System.out.println("Remove, HashSet: " + (hashRemEnd - hashRemStart) / 1_000_000_000
                + " LinkedHashSet: " + (linkRemEnd - linkRemStart) / 1_000_000_000
                + " TreeSet: " + (treeRemEnd - treeRemStart) / 1_000_000_000);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
    }

}
