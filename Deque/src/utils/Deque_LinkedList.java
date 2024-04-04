package utils;

import java.util.NoSuchElementException;

public class Deque_LinkedList<E> implements IDeque<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public Deque_LinkedList()
    {
        tail = null;
        head = null;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void addFirst(E elementToAdd)
    {
        if (elementToAdd == null) throw new IllegalArgumentException();

        Node<E> node = new Node<>(null, elementToAdd, null);
        if (head == null) {
            head = node;
            tail = head;
        }
        else
        {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public E getFirst()
    {
        if (this.head == null)
        {
            return null;
        }
        return this.head.value;
    }

    public E removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node<E> toReturn = head;
        head = head.next;
        size--;
        return toReturn.value;
    }

    public void addLast(E elementToAdd)
    {
        if (elementToAdd == null) throw new IllegalArgumentException();

        Node<E> node = new Node<>(null, elementToAdd, null);
        node.value = elementToAdd;

        if (head == null)
        {
            tail = node;
            head = tail;
        }
        else
        {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public E getLast()
    {
        if (this.tail == null)
        {
            return null;
        }
        return this.tail.value;
    }

    public E removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node<E> toReturn = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return toReturn.value;
    }

    public int size()
    {
        return this.size;
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "Deque is empty.";
        }

        StringBuilder deque = new StringBuilder();
        Node<E> first = head;
        deque.append("Deque elements: [ ").append(first.value).append(" ");
        while (first.next != null)
        {
            deque.append(first.next.value).append(" ");
            first = first.next;
        }
        deque.append("]");

        return deque.toString();
    }

    private static class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        private Node(Node<E> previous, E current, Node<E> next) {
            this.value = current;
            this.previous = previous;
            this.next = next;
        }

    }


}
