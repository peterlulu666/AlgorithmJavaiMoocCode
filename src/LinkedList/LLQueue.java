package LinkedList;

public interface LLQueue<AnyType> {
    int getSize();

    boolean isEmpty();

    void enQueue(AnyType data);

    AnyType deQueue();

    AnyType getFront();

}
