package StringToArrayOfInteger;

import java.util.Arrays;
import java.util.stream.Stream;

// String to array of integer
public class StringToArray {
    private String numbers;
    private String splitBy = "";
    private String[] numberSplit;
    private int numberSplitLength = 0;
    private int numberLength = 0;
    private int[] numberArray;
    private String[] strArray;
    private int strArrayLength = 0;

    public StringToArray(String numbers, String splitBy) {
        this.numbers = numbers;
        this.splitBy = splitBy;
        this.numberSplit = this.numbers.split(this.splitBy);
        this.numberSplitLength = this.numberSplit.length;

    }

    public StringToArray(String numbers) {
        this.numbers = numbers;
        this.numberLength = this.numbers.length();

    }

    public StringToArray(String[] strArray) {
        this.strArray = strArray;
        this.strArrayLength = this.strArray.length;

    }

    public void strToArr() {
        this.numberArray = new int[this.numberSplitLength];
        for (int i = 0; i < this.numberSplitLength; i++) {
            this.numberArray[i] = Integer.parseInt(this.numberSplit[i]);

        }

    }

    public void strToArrMapToInt() {
        this.numberArray = Stream.of(this.numberSplit).mapToInt(value -> Integer.parseInt(value)).toArray();

    }

    public void stringArrayToIntegerArray() {
        this.numberArray = new int[this.strArrayLength];
        for (int i = 0; i < this.strArrayLength; i++) {
            this.numberArray[i] = Integer.parseInt(this.strArray[i]);

        }

    }

    public void strToArrConsecutive() {
        this.numberArray = new int[this.numberLength];
        for (int i = 0; i < this.numberLength; i++) {
            this.numberArray[i] = Integer.parseInt(String.valueOf(this.numbers.charAt(i)));

        }

    }

    @Override
    public String toString() {
        String str = "";
        str = str + Arrays.toString(this.numberArray);
        str = str + "\n";
        // Variable type
        str = str + this.numberArray.getClass().getComponentType();
        return str;


    }

}
