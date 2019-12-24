package LinkedList;

public interface LL<E> {
    void add(int index, E data);

    void addFirst(E data);

    void addLast(E data);

    boolean contains(E data);

    E get(int index);

    E getFirst();

    E getLast();

    int getSize();

    boolean isEmpty();

    E removeNode(E data);

    E remove(int index);

    E removeFirst();

    E removeLast();

    void set(int index, E data);


}
