package Queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enQueue(E data);
    E deQueue();
    E getFront();

}
