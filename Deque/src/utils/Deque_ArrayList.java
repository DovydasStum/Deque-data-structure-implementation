package utils;

import java.util.NoSuchElementException;

public class Deque_ArrayList<E> implements IDeque<E>
{
    private E[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    private static int DEFAULT_CAPACITY = 20;

    public Deque_ArrayList(int capacity)
    {
        elements = (E[]) (new Object[capacity]);
    }

    public Deque_ArrayList()
    {
        elements = (E[]) (new Object[DEFAULT_CAPACITY]);
    }

    public void addFirst(E element) {
        ensureCapacity();

        headIndex = decreaseIndex(headIndex);
        elements[headIndex] = element;
        numberOfElements++;
    }

    public void addLast(E element) {
        ensureCapacity();

        elements[tailIndex] = element;
        tailIndex = increaseIndex(tailIndex);
        numberOfElements++;
    }

    public E removeFirst() {
        E element = elementAtHead();
        elements[headIndex] = null;
        headIndex = increaseIndex(headIndex);
        numberOfElements--;
        return element;
    }

    public E removeLast() {
        E element = elementAtTail();
        tailIndex = decreaseIndex(tailIndex);
        elements[tailIndex] = null;
        numberOfElements--;
        return element;
    }

    public E getFirst() {
        return elementAtHead();
    }

    public E getLast() {
        return elementAtTail();
    }

    private E elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[headIndex];
        return element;
    }

    private E elementAtTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = (E) elements[decreaseIndex(tailIndex)];
        return element;
    }

    private int decreaseIndex(int index) {
        index--;
        if (index < 0) {
            index = elements.length - 1;
        }
        return index;
    }

    private int increaseIndex(int index) {
        index++;
        if (index == elements.length) {
            index = 0;
        }
        return index;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public int size()
    {
        return numberOfElements;
    }

    private void ensureCapacity()
    {
        if (size() == elements.length)
        {
            E[] ensuredArray = (E[]) (new Object[elements.length * 2]);
            for (int i = 0; i < numberOfElements; i++)
            {
                ensuredArray[i] = elements[headIndex];
                headIndex = (headIndex + 1) % elements.length;
            }
            headIndex = 0;
            tailIndex = numberOfElements;
            elements = ensuredArray;
        }
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "Deque is empty.";
        }

        String deque = "Deque elements: [ ";
        for (int i = headIndex, j = 0; j < numberOfElements; i = (i+1) % elements.length, j++)
        {
            if (elements[i] != null)
                deque = deque + elements[i].toString() + " ";
            else if (elements[j] != null)
            {
                deque = deque + elements[j].toString()+ " ";
            }
        }
        deque = deque + "]";
        return deque;
    }


}
