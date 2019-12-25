package LinkedList;

public interface LL<AnyType> {
    void add(int index, AnyType data);

    void addFirst(AnyType data);

    void addLast(AnyType data);

    boolean contains(AnyType data);

    AnyType get(int index);

    AnyType getFirst();

    AnyType getLast();

    int getSize();

    boolean isEmpty();

    AnyType removeNode(AnyType data);

    AnyType remove(int index);

    AnyType removeFirst();

    AnyType removeLast();

    void set(int index, AnyType data);


}
