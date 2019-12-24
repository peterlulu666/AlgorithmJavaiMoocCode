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
        Node<E> tmpPointer = head;
        while (tmpPointer != null) {
            if (tmpPointer.data.equals(data)) {
                return true;

            }
            tmpPointer = tmpPointer.next;

        }
        return false;

    }

    @Override
    public E get(int index) {
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        Node<E> tmpPointer = head;
        for (int countMove = 1; countMove <= index; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        return tmpPointer.data;

    }

    @Override
    public E getFirst() {
        return head.data;

    }

    @Override
    public E getLast() {
        Node<E> tmpPointer = head;
        for (int i = 1; i <= currentSize - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        return tmpPointer.data;

    }

    @Override
    public int getSize() {
        return currentSize;

    }

    @Override
    public boolean isEmpty() {
        return head == null;

    }

    @Override
    public E removeNode(E data) {
        if (head == null) {
            return null;

        }
        if (head.data.equals(data)){
            return removeFirst();

        }
        Node<E> tmpPointer = head;
        Node<E> prevPointer = null;
        while (tmpPointer != null) {
            if (tmpPointer.data.equals(data)) {
                prevPointer.next = tmpPointer.next;
                currentSize--;
                return data;

            }
            prevPointer = tmpPointer;
            tmpPointer = tmpPointer.next;

        }
        return null;

    }


    @Override
    public E remove(int index) {
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        Node<E> tmpPointer = head;
        if (index == 0) {
            return removeFirst();

        }
        for (int i = 1; i <= index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        E removedData = (E) tmpPointer.next.data;
        tmpPointer.next = tmpPointer.next.next;
        currentSize--;
        return removedData;

    }

    @Override
    public E removeFirst() {
        if (head == null) {
            return null;

        }
        E removedData = head.data;
        Node<E> tmpPointer = head;
        tmpPointer = tmpPointer.next;
        head = tmpPointer;
        currentSize--;
        return removedData;

    }

    @Override
    public E removeLast() {
        if (head == null) {
            return null;

        }
        if (head.next == null) {
            return removeFirst();

        }
        Node<E> tmpPointer = head;
        for (int i = 1; i <= currentSize - 2; i++) {
            tmpPointer = tmpPointer.next;

        }
        E removedData = (E) tmpPointer.next.data;
        tmpPointer.next = null;
        currentSize--;
        return removedData;

    }

    @Override
    public void set(int index, E data) {
        if (index < 0 || index > currentSize - 1) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        Node<E> tmpPointer = head;
        for (int countMove = 1; countMove <= index; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.data = data;

    }

    public void show() {
        Node<E> tmpPointer = head;
        for (int i = 0; i < currentSize; i++) {
            System.out.print("[ " + tmpPointer.data + " ]-> ");
            tmpPointer = tmpPointer.next;

        }
        System.out.println(" null ");

    }

    public static void main(String[] args) {
        var linkedList = new LinkedList<Integer>();
        linkedList.addFirst(100);
        linkedList.addFirst(200);
        linkedList.addLast(300);
        linkedList.add(2, 500);
        linkedList.show();
        System.out.println(linkedList.contains(300));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        linkedList.addFirst(800);
        linkedList.addFirst(500);
        linkedList.set(2, 600);
        linkedList.show();
        System.out.println(linkedList.removeNode(1000));
        linkedList.show();


    }
}
