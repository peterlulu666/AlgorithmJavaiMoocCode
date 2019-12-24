package LinkedList;

public class LinkedList<E> implements LL<E> {
    Node<E> head;
    int currentSize;

    public LinkedList() {
        this.head = null;
        this.currentSize = 0;

    }

    @Override
    public void add(int index, E data) {
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        if (index == 0) {
            addFirst(data);
            return;

        }
        Node<E> newNode = new Node<E>(data);
        Node<E> tmpPointer = head;
        for (int i = 1; i <= index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        newNode.next = tmpPointer.next;
        tmpPointer.next = newNode;
        currentSize++;

    }

    @Override
    public void addFirst(E data) {
        Node<E> newNode = new Node<E>(data);
        newNode.next = head;
        head = newNode;
        currentSize++;

    }

    @Override
    public void addLast(E data) {
        if (head == null) {
            addFirst(data);
            return;

        }
        Node<E> newNode = new Node<E>(data);
        Node<E> tmpPointer = head;
        for (int i = 1; i < currentSize; i++) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.next = newNode;
        newNode.next = null;
        currentSize++;

    }

    @Override
    public boolean contains(E data) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void show() {
        Node<E> tmpPointer = head;
        for (int i = 0; i < currentSize; i++) {
            System.out.print("[ " + tmpPointer.data + " ]-> ");
            tmpPointer = tmpPointer.next;

        }

    }

    public static void main(String[] args) {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFirst(100);
        linkedList.addFirst(200);
        linkedList.addLast(300);
        linkedList.add(3, 500);
        linkedList.show();


    }
}
