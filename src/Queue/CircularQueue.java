package Queue;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue<E> {
    E[] queueArray;
    int size;
    int frontIndex;
    int rearIndex;

    public CircularQueue(int capacity) {
        this.queueArray = (E[]) new Object[capacity];
        this.size = 0;
        this.frontIndex = 0;
        this.rearIndex = 0;

    }

    public CircularQueue() {
        this(10);

    }

    public int getSize() {
        return this.size;

    }

    public int getCapacity() {
        return this.queueArray.length - 1;

    }

    public boolean isEmpty() {
        return this.frontIndex == this.rearIndex;

    }

    public boolean isFull() {
        return (this.rearIndex + 1) % this.queueArray.length == this.frontIndex;

    }

    //  frontIndex                    rearIndex
    //   +                             +
    //   |                             |
    //   |                             |
    //   v                             v
    //+--+--+-----+-----+-----+-----+--+--+
    //|     |     |     |     |     |     |
    //|  1  |  2  |  3  |  4  |  5  |     |
    //|     |     |     |     |     |     |
    //+-----+-----+-----+-----+-----+-----+
    public void enQueue(E data) {
        if (isFull()) {
            throw new IllegalArgumentException("The queue array is full. ");

        }
        this.queueArray[this.rearIndex] = data;
        this.rearIndex = (this.rearIndex + 1) % this.queueArray.length;
        this.size++;

    }

    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue array is empty. ");

        }
        E frontData = this.queueArray[this.frontIndex];
        this.frontIndex = (this.frontIndex + 1) % this.queueArray.length;
        this.size--;
        return frontData;

    }

    public E getFront() {
        return this.queueArray[this.frontIndex];

    }

    @Override
    public String toString() {
        String str = "";
        str = str + "The size is " + getSize() + " and " + "the capacity is " + getCapacity() + "\n";
        str = str + "[ front ";
        for (int i = this.frontIndex; i != this.rearIndex; i = (i + 1) % this.queueArray.length) {
            str = str + this.queueArray[i] + ", ";

        }
        str = str + "rear ] ";
        System.out.println(Arrays.toString(this.queueArray));
        return str;

    }

    public static void main(String[] args) {
        var circularQueue = new CircularQueue<Integer>(5);
        circularQueue.enQueue(100);
        circularQueue.enQueue(80);
        circularQueue.enQueue(60);
        circularQueue.enQueue(50);
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        System.out.println(circularQueue);


    }
}
