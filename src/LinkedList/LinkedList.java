package LinkedList;

public class LinkedList<AnyType> implements LL<AnyType> {
    Node<AnyType> head;
    int currentSize;

    public LinkedList() {
        this.head = null;
        this.currentSize = 0;

    }

    @Override
    public void add(int index, AnyType data) {
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        if (index == 0) {
            addFirst(data);
            return;

        }
        Node<AnyType> newNode = new Node<AnyType>(data);
        Node<AnyType> tmpPointer = head;
        for (int countMove = 1; countMove <= index - 1; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        newNode.next = tmpPointer.next;
        tmpPointer.next = newNode;
        currentSize++;

    }

    @Override
    public void addFirst(AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data);
        newNode.next = head;
        head = newNode;
        currentSize++;

    }

    @Override
    public void addLast(AnyType data) {
        if (head == null) {
            addFirst(data);
            return;

        }
        Node<AnyType> newNode = new Node<AnyType>(data);
        Node<AnyType> tmpPointer = head;
        for (int countMove = 1; countMove < currentSize; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.next = newNode;
        newNode.next = null;
        currentSize++;

    }

    @Override
    public boolean contains(AnyType data) {
        if (this.head == null) {
            return false;

        }
        Node<AnyType> tmpPointer = this.head;
        // Traverse the pointer to last node and run the code
        for (int compareWithIndex = 0; compareWithIndex <= this.currentSize - 1; compareWithIndex++) {
            if (tmpPointer.data.equals(data)) {
                return true;

            }
            tmpPointer = tmpPointer.next;

        }
        return false;

//        if (head == null) {
//            return false;
//
//        }
//        Node<AnyType> tmpPointer = head;
//        // Traverse the pointer to the last node and run the code
//        while (tmpPointer != null) {
//            if (tmpPointer.data.equals(data)) {
//                return true;
//
//            }
//            tmpPointer = tmpPointer.next;
//
//        }
//        return false;

    }

    @Override
    public AnyType get(int index) {
        if (head == null) {
            return null;

        }
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        Node<AnyType> tmpPointer = head;
        for (int countMove = 1; countMove <= index; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        return tmpPointer.data;

    }

    @Override
    public AnyType getFirst() {
        if (head == null) {
            return null;

        }
        return head.data;
//        return get(0);

    }

    @Override
    public AnyType getLast() {
        if (this.head == null) {
            return null;

        }
        Node<AnyType> tmpPointer = this.head;
        // Traverse to the second last node and run the code
        while (tmpPointer.next != null) {
            tmpPointer = tmpPointer.next;

        }
        return tmpPointer.data;

//        if (head == null){
//            return null;
//
//        }
//        Node<AnyType> tmpPointer = head;
//        for (int moveToIndex = 1; moveToIndex <= currentSize - 1; moveToIndex++) {
//            tmpPointer = tmpPointer.next;
//
//        }
//        return tmpPointer.data;
//        return get(currentSize - 1);
//        Node<E> tmpPointer = head;
//        // Traverse to the second last node and run the code
//        while(tmpPointer.next != null){
//            tmpPointer = tmpPointer.next;
//
//        }
//        return tmpPointer.data;

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
    public AnyType removeNode(AnyType data) {
        if (head == null) {
            return null;

        }
        if (head.data.equals(data)) {
            return removeFirst();

        }
        Node<AnyType> tmpPointer = head;
        Node<AnyType> prevPointer = null;
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
    public AnyType remove(int index) {
        if (head == null) {
            return null;

        }
        if (index < 0 || index > currentSize) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        if (index == 0) {
            return removeFirst();

        }
        Node<AnyType> tmpPointer = head;
        for (int countMove = 1; countMove <= index - 1; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        AnyType removedData = (AnyType) tmpPointer.next.data;
        tmpPointer.next = tmpPointer.next.next;
        currentSize--;
        return removedData;

    }

    @Override
    public AnyType removeFirst() {
        if (head == null) {
            return null;

        }
        AnyType removedData = head.data;
        Node<AnyType> tmpPointer = head;
        tmpPointer = tmpPointer.next;
        head = tmpPointer;
        currentSize--;
        return removedData;

    }

    @Override
    public AnyType removeLast() {
        if (head == null) {
            return null;

        }
        if (head.next == null) {
            return removeFirst();

        }
        Node<AnyType> tmpPointer = head;
        for (int i = 1; i <= currentSize - 2; i++) {
            tmpPointer = tmpPointer.next;

        }
        AnyType removedData = (AnyType) tmpPointer.next.data;
        tmpPointer.next = null;
        currentSize--;
        return removedData;

    }

    @Override
    public void set(int index, AnyType data) {
        if (head == null) {
            return;

        }
        if (index < 0 || index > currentSize - 1) {
            throw new IllegalArgumentException("The index should be between 0 and linked list size. ");

        }
        Node<AnyType> tmpPointer = head;
        for (int countMove = 1; countMove <= index; countMove++) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.data = data;

    }

    public void show() {
        Node<AnyType> tmpPointer = head;
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
        linkedList.set(0, 500);
        linkedList.removeNode(500);
        linkedList.show();


    }
}
