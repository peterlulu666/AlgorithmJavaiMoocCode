package Queue;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> arrayQueue;

    public ArrayQueue(int capacity) {
        this.arrayQueue = new Array<E>(capacity);

    }

    public ArrayQueue() {
        this.arrayQueue = new Array<E>(10);

    }

    @Override
    public int getSize() {
        return arrayQueue.getSize();

    }

    @Override
    public boolean isEmpty() {
        return arrayQueue.isEmpty();

    }

    @Override
    public void enQueue(E data) {
        arrayQueue.addLast(data);
    }

    @Override
    public E deQueue() {
        return arrayQueue.removeFirst();

    }

    @Override
    public E getFront() {
        return arrayQueue.getNumber(0);

    }

    public static void main(String[] args) {
        var arrayQueue = new ArrayQueue<Integer>();
        arrayQueue.enQueue(20);
        arrayQueue.enQueue(100);
        arrayQueue.enQueue(100);
        arrayQueue.enQueue(10);
        System.out.println(arrayQueue.getSize());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.getFront());
        System.out.println(arrayQueue.getSize());

    }
}
