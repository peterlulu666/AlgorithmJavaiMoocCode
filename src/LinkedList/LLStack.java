package LinkedList;

public interface LLStack<AntType> {
    int getSize();

    boolean isEmpty();

    AntType pop();

    void push(AntType data);

    AntType peak();


}
