package com.mycompany.listimplementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int N = 0;

    @Override
    public void add(E element) {
        Node<E> node = new Node(element);
        if (N == 0) {
            first = node;
            last = first;
            N++;
        } else {
            last.setNextNode(node);
            last = node;
            N++;
        }
    }
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > N) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 && N == 0 || index == N) {
            add(element);
            return;
        }
        if (index == 0 && N > 0) {
            first = new Node(element, first);
            N++;
            return;
        }
        Node<E> x = first;
        for (int i = 0; i < index - 1; i++) {
            x = x.getNextNode();
        }
        Node newElement = new Node(element, x.getNextNode());
        x.setNextNode(newElement);
        N++;
    }

    public E remove() {
        Node<E> current = first;

        if (first.getNextNode() == null) {
            last = null;
        }
            first = first.getNextNode();
            N--;
            return current.getElement();
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = first;
        Node<E> previous = first;
        while (current.getElement() != get(index)) {
            if (current.getNextNode() == null) {
                return null;
            } else {
                previous = current;
                current = current.getNextNode();
            }
        }
        if (current == first) {
            first = first.getNextNode();
        } else {
            previous.setNextNode(current.getNextNode());
        }
        N --;
        return current.getElement();
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.getNextNode();
            x.setElement(null);
            x.setNextNode(null);
            x = next;
        }
        first = last = null;
        N = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.getNextNode();
        return x.getElement();
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = first; x != null; x = x.getNextNode()) {
                if (x.getElement() == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.getNextNode()) {
                if (element.equals(x.getElement()))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.getNextNode();
        E oldElement = x.getElement();
        x.setElement(element);
        return oldElement;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public E[] toArray() {
        Object[] result = new Object[N];
        E[] resultT = (E[]) result;
        int i = 0;
        for (Node<E> x = first; x != null; x = x.getNextNode())
            resultT[i++] = x.getElement();
        return resultT;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            s.append(current);
            s.append(' ');
            current = current.getNextNode();
        }
        return s.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedIterator(Node<E> first) {
            current = first;
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E node = current.getElement();
            current = current.getNextNode();
            return node;
        }
    }

}
