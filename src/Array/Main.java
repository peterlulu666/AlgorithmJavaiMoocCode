package Array;

import java.util.Arrays;
import java.util.Scanner;

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

//        var arr = new Array(20);
//        for (int i = 0; i < 10; i++) {
//            arr.addLast(i);
//        }
//        System.out.println(arr);

//        // StringBuilder
//        StringBuilder arrayString = new StringBuilder();
        String numbers = "";
        // User input number to array
        while (true) {
            System.out.println("Enter a number or press q to quit ");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            if (number.equals("q")) {
                break;

            }

            numbers = numbers + number;
//            // StringBuilder
//            arrayString.append(numberString);
        }

        // String to array of integer
        var arr = new ArrayAlgorithm(numbers.length() + 1);
        for (int i = 0; i < numbers.length(); i++) {
            arr.addLast(Integer.parseInt(numbers.split("")[i]));

        }


        arr.add(1, 6);
        System.out.println(arr);

        System.out.println("The highest index where number appears " + arr.find(6));

        // String to array of string
        System.out.println("We would find number in this index " + Arrays.toString(arr.findAll(6)) );




        System.out.println(arr);

        arr.remove(3);
        System.out.println(arr);

        arr.removeNumber(7);
        System.out.println(arr);

        arr.removeAllNumber(6);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);


    }
}
