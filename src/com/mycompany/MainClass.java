package com.mycompany;

import com.mycompany.listimplementation.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        MyLinkedList<Circle> myLinkedList = new MyLinkedList();
        LinkedList<Circle> linkedList = new LinkedList();

        for (int i = 0; i < 10000; i++) {
            linkedList.add(new Circle());
        }

        for (int i = 0; i < 10000; i++) {
            myLinkedList.add(new Circle());
        }

        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }


        for (int i = 0; i < 10000; i++) {
            myLinkedList.get(i);
        }

        double startLL = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            linkedList.remove();
        double endLL = System.nanoTime();
        double totalLL = (endLL - startLL) / 1_000_000_000;
        double startMLL = System.nanoTime();
        Circle[] circles = new Circle[myLinkedList.size()];
        System.out.println(Arrays.toString(myLinkedList.toArray(circles)));
        for (int i = 0; i < 10000; i++)
            myLinkedList.remove();
        double endMLL = System.nanoTime();
        double totalMLL = (endMLL - startMLL) / 1_000_000_000;
        System.out.println(totalLL);
        System.out.println(totalMLL);


    }


    }

