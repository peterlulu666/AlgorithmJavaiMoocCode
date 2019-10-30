package Array;

public class Main {

    public static void main(String[] args) {
//        // Create array with size
//        int[] arr = new int[20];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//
//        }
//
//        // Create array with element
//        int[] score = new int[]{100, 99, 66};
//        for (int i = 0; i < score.length; i++) {
//            System.out.println(score[i]);
//        }

        var arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeNumber(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }
}
