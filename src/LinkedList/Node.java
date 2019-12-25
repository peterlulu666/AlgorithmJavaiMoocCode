package LinkedList;

public class Node<AnyType> {
    Node next;
    AnyType data;

    public Node(AnyType data) {
        this.data = data;
        this.next = null;

    }
}
