package utils;

import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        linkedListTests();
        //arrayTests();
    }

    public static void linkedListTests()
    {
        Deque_LinkedList<Integer> deque = new Deque_LinkedList<>();
        System.out.println("Tests:\n");
        System.out.println(deque);
        deque.addFirst(1);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addFirst(2);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addFirst(3);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());

        deque.addLast(4);
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());
    }

    public static void arrayTests()
    {
        Deque_ArrayList<Integer> deque = new Deque_ArrayList<>(2);
        System.out.println("Tests:\n");
        System.out.println(deque);
        deque.addFirst(1);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addFirst(2);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        deque.addFirst(3);
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println(deque);
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());

        deque.addLast(4);
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());

        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println(deque);
        System.out.println("getLast(): " + deque.getLast());

    }

}
