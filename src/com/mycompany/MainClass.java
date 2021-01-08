package com.mycompany;

import com.mycompany.listimplementation.MyLinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        LinkedList linkedList = new LinkedList();


        //myLinkedList.add(0, 2);
        //myLinkedList.add(1,1);

        for (int i = 0; i < 20; i++) {
            myLinkedList.add(i+1);
            linkedList.add(i+1);
        }
        System.out.println(myLinkedList.get(myLinkedList.size() - 1));
        System.out.println(myLinkedList.indexOf(19));
        linkedList.add(19,0);
        myLinkedList.add(19,0);
        linkedList.add(0,0);
        myLinkedList.add(0,0);
        Iterator i = myLinkedList.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println(linkedList);
        System.out.println(myLinkedList);
    }


}
