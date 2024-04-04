package utils;

public interface IDeque<E> {
    void addFirst(E e);
    E getFirst();
    E removeFirst();
    void addLast(E e);
    E getLast();
    E removeLast();
    boolean isEmpty();
}
