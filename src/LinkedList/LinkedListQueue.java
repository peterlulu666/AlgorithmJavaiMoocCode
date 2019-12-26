package LinkedList;

public class LinkedListQueue<AnyType> implements LLQueue<AnyType> {
    class Node<AnyType> {
        AnyType data;
        Node<AnyType> next;

        public Node(AnyType data) {
            this.data = data;
            this.next = null;

        }

    }

    Node<AnyType> head;
    Node<AnyType> tail;
    int currentSize;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;

    }

    @Override
    public int getSize() {
        return currentSize;

    }

    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);

    }

    @Override
    public void enQueue(AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            currentSize++;
            return;

        }
        tail.next = newNode;
        tail = newNode;
        currentSize++;

    }

    @Override
    public AnyType deQueue() {
        if (isEmpty()) {
            return null;

        }
        AnyType removedData = head.data;
        if (head.next == null) {
            head = null;
            tail = null;
            currentSize--;
            return removedData;

        }
        Node<AnyType> tmpPointer = head;
        tmpPointer = tmpPointer.next;
        head = tmpPointer;
        currentSize--;
        return removedData;

    }

    @Override
    public AnyType getFront() {
        if (isEmpty()) {
            return null;

        }
        return head.data;

    }

    public void show() {
        Node<AnyType> tmpPointer = head;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(" [ " + tmpPointer.data + " ] -> ");
            tmpPointer = tmpPointer.next;

        }
        System.out.println(" null ");

    }

    public static void main(String[] args) {
        var linkedListQueue = new LinkedListQueue<Integer>();
        linkedListQueue.enQueue(500);
        linkedListQueue.enQueue(600);
        System.out.println(linkedListQueue.deQueue());
        linkedListQueue.show();


    }
}
