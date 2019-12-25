package LinkedList;

public class LinkedListStack<AnyType> implements LLStack<AnyType> {

    class Node<AnyType> {
        AnyType data;
        Node next;

        public Node(AnyType data) {
            this.data = data;
            this.next = null;

        }

    }

    Node<AnyType> head;
    int currentSize;

    public LinkedListStack() {
        this.head = null;
        this.currentSize = 0;

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
    public AnyType pop() {
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
    public void push(AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data);
        newNode.next = head;
        head = newNode;
        currentSize++;

    }

    @Override
    public AnyType peak() {
        return head.data;

    }

    public void show() {
        Node<AnyType> tmpPointer = head;
        for (int i = 0; i < currentSize; i++) {
            System.out.print("[ " + tmpPointer.data + " ] -> ");
            tmpPointer = tmpPointer.next;


        }
        System.out.println(" null ");

    }

    public static void main(String[] args) {
        var linkedListStack = new LinkedListStack<Integer>();
        linkedListStack.push(600);
        linkedListStack.push(500);
        linkedListStack.push(800);
        linkedListStack.show();
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.peak());
        linkedListStack.show();


    }

}
