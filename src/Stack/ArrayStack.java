package Stack;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);

    }

    public ArrayStack() {
        array = new Array<E>();
        
    }

    @Override
    public int getSize() {
        return array.getSize();

    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();

    }

    @Override
    public E pop() {
        return array.removeLast();

    }

    @Override
    public void push(E data) {
        array.addLast(data);

    }

    @Override
    public E peak() {
        return array.getNumber(getSize() - 1);

    }

    public static void main(String[] args) {
        var arrayStack = new ArrayStack<Integer>(5);
        arrayStack.push(100);
        System.out.println(arrayStack.peak());
        System.out.println(arrayStack.getSize());






    }
}
