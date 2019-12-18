package Array;

public class ArrayGenerics<E> {
    // Create data array
    private E[] dataArray;
    // The number of element in array
    private int numberOfElement;
    // The capacity of array
    private int arraySize;

    /**
     * Constructor
     *
     * @param arraySize
     */
    public ArrayGenerics(int arraySize) {
        this.arraySize = arraySize;
        // Generic array
        dataArray = (E[]) new Object[this.arraySize];
        this.numberOfElement = 0;

    }

    /**
     * Constructor, the default size is 10
     */
    public ArrayGenerics() {
        this(10);
    }

    /**
     * isEmpty
     *
     * @return When array is empty return true
     */
    public boolean isEmpty() {
        return numberOfElement == 0;
    }

    /**
     * isFull
     *
     * @return When array is full return true
     */
    public boolean isFull() {
        return numberOfElement == dataArray.length;

    }

//    /**
//     * Add element in the rear of array
//     */
//    public void addLast(int number) {
//        if (isFull()) {
//            throw new IllegalArgumentException("Array is full");
//
//        }
//        dataArray[numberOfElement] = number;
//        numberOfElement++;
////        // Simplify
////        dataArray[numberOfElement++] = number;
//
//    }

    // We would write addLast function like this

    /**
     * addLast
     * Add element in the rear of array
     *
     * @param number
     */
    public void addLast(E number) {
        add(numberOfElement, number);

    }

    // We would write addFirst function like this

    /**
     * addFirst
     * Add element in the front of array
     *
     * @param number
     */
    public void addFirst(E number) {
        add(0, number);

    }


    public void add(int index, E number) {
        if (index < 0 || index > numberOfElement) {
            throw new IllegalArgumentException("Index should be greater than 0 and less than or equal to the number of element");

        }
        if (isFull()) {
            extend(2 * dataArray.length);

        }
        // We would copy the element from index i to index i + 1
        // The index is starting from 0
        // The number of element is starting from 1
        //                                          number of element
        //                                                +
        //                                                |
        //                                                v
        //           +------+--------+-------+--------+---+---+-------+-------+
        //           |      |        |       |        |       |       |       |
        //data array |  66  |   88   |  99   |   100  |       |       |       +<----+ array size
        //           +------+--------+-------+--------+-------+-------+-------+
        //    index     0       1       2        3       4        5      6
        //
        //                                                 number of element
        //                                                        +
        //                                                        |
        //                                                        v
        //           +------+--------+-------+--------+-------+---+---+-------+
        //           |      |        |       |        |       |       |       |
        //data array |  66  |   88   |  88   |   99   |  100  |       |       +<----+ array size
        //           +------+--------+-------+--------+-------+-------+-------+
        //    index     0       1       2        3       4        5      6
        //
        //
        //                                                 number of element
        //                                                        +
        //                                                        |
        //                                                        v
        //           +------+--------+-------+--------+-------+---+---+-------+
        //           |      |        |       |        |       |       |       |
        //data array |  66  |   77   |  88   |   99   |  100  |       |       +<----+ array size
        //           +------+--------+-------+--------+-------+-------+-------+
        //    index     0       1       2        3       4        5      6
        //
        // Starting from number of element - 1 to the index
        // Let's say that we would add number in index 1
        // We would copy the number from index 4 to number in index 5
        for (int i = numberOfElement - 1; i >= index; i--) {
            dataArray[i + 1] = dataArray[i];

        }
//        // Simplify
//        System.arraycopy(dataArray, index, dataArray, index + 1, numberOfElement - index);
        // We would safely overwrite the element in the index
        dataArray[index] = number;
        numberOfElement++;

    }

    /**
     * getNumber
     *
     * @param index
     * @return number in the index
     */
    public E getNumber(int index) {
        if (index < 0 || index >= numberOfElement) {
            throw new IllegalArgumentException("Index should be greater than 0 and less than number of element");
        }
        return dataArray[index];

    }

    /**
     * setNumber
     * Set number in the index
     *
     * @param index
     * @param number
     */
    public void setNumber(int index, E number) {
        if (index < 0 || index >= numberOfElement) {
            throw new IllegalArgumentException("Index should be greater than 0 and less than number of element");
        }
        dataArray[index] = number;

    }

    /**
     * contains
     *
     * @param number
     * @return When the array contains the number returns true
     */
    public boolean contains(E number) {
        boolean status = false;
        for (int i = 0; i < numberOfElement; i++) {
            if (dataArray[i].equals(number)) {
                status = true;

            }
//            // Simplify
//            status = dataArray[i] == number;
        }
        return status;

    }

    /**
     * find
     * When the number exists in the array return the index of number
     *
     * @param number
     * @return the highest index where the number appears
     */
    public int find(E number) {
        int index = -1;
        for (int i = 0; i < numberOfElement; i++) {
            if (dataArray[i].equals(number)) {
                index = i;

            }
//            // Simplify
//            index = dataArray[i] == number ? i : -1;

        }

        return index;

    }

    public int[] findAll(E number) {
        String index = "";
        for (int i = 0; i < numberOfElement; i++) {
            if (dataArray[i] == number) {

                index = index + i + " ";

            }
//            // Simplify
//            index = dataArray[i] == number ? i : -1;

        }


        // String to array of integer
        String[] indexSplit = index.split(" ");
        int[] allIndex = new int[indexSplit.length];
        for (int i = 0; i < indexSplit.length; i++) {
            allIndex[i] = Integer.parseInt(indexSplit[i]);


        }

        return allIndex;


    }

    public E remove(int index) {
        if (isEmpty()){
            throw new IllegalArgumentException("The array is empty.");

        }
        if (index < 0 || index >= numberOfElement) {
            throw new IllegalArgumentException("Index should be greater than 0 and less than number of element");

        }
        // dataArray.length / 4 has better time complexity than dataArray.length / 2
        if (numberOfElement < dataArray.length / 4 && dataArray.length / 2 != 0){
            extend(dataArray.length / 2);

        }
        E removedNumber = dataArray[index];
        // We would copy the element from index i to index i - 1
        //                                                  number of element
        //                                                        +
        //                                                        |
        //                                                        v
        //           +------+--------+-------+--------+-------+---+---+-------+
        //           |      |        |       |        |       |       |       |
        //data array |  66  |   77   |  88   |   99   |  100  |       |       +<----+ array size
        //           +------+--------+-------+--------+-------+-------+-------+
        //    index     0       1       2        3       4        5      6
        //
        //
        //                                         number of element
        //                                                +
        //                                                |
        //                                                v
        //           +------+--------+-------+--------+---+---+-------+-------+
        //           |      |        |       |        |       |       |       |
        //data array |  66  |   88   |  99   |   100  |  100  |       |       +<----+ array size
        //           +------+--------+-------+--------+-------+-------+-------+
        //    index     0       1       2        3       4        5      6
        //
        // Starting from the index + 1 to the number of element
        // Let's say that we would remove the number in index 1
        // We would copy the number in index 2 to number in index 1
        // There are two 100 in the array
        // The last 100 is inaccessible
        for (int i = index + 1; i < numberOfElement; i++) {
            dataArray[i - 1] = dataArray[i];

        }
        numberOfElement--;
        return removedNumber;

    }

    /**
     * removeFirst
     * Remove the number in index 0
     *
     * @return the number that has been removed
     */
    public E removeFirst() {
        return remove(0);

    }

    /**
     * removeLast
     * Remove the number in index of last number
     *
     * @return the number that has been removed
     */
    public E removeLast() {
        return remove(numberOfElement - 1);

    }

    /**
     * removeNumber
     * Remove the number in the highest index where it appears
     *
     * @param number
     */
    public void removeNumber(E number) {
        int index = find(number);
        if (index != -1) {
            remove(index);

        }

    }

    public void removeAllNumber(E number) {
        int count = 0;
        int findAllLength = findAll(number).length;
        while (true) {
            if (count == findAllLength) {
                break;
            } else {
                remove(Integer.parseInt(String.valueOf(findAll(number)[0])));
                count++;

            }
        }
//        for (int i = 0; i < Integer.parseInt(String.valueOf(findAll(number).length())); i++) {
//            remove(Integer.parseInt(String.valueOf(findAll(number).charAt(0))));
//
//        }


    }

    public void extend(int extendedArrSize) {
        E[] extendedArr = (E[]) new Object[extendedArrSize];
        for (int i = 0; i < numberOfElement; i++) {
            extendedArr[i] = dataArray[i];

        }
        dataArray = extendedArr;

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append((String.format("Array: number of element = %d , array size = %d \n", numberOfElement, dataArray.length)));
        result.append("[");
        for (int i = 0; i < numberOfElement; i++) {
            result.append(dataArray[i]);
            if (i != numberOfElement - 1) {
                result.append(", ");

            }

        }
        result.append("]");
        return result.toString();

    }
}































