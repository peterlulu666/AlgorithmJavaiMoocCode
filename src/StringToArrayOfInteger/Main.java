package StringToArrayOfInteger;

public class Main {
    public static void main(String[] args) {
        // String to array
        String str = "1 2 3 4 5 6 7 8 9 10";
        var stringToArray = new StringToArray(str, " ");
        stringToArray.strToArr();
        System.out.println(stringToArray);
        stringToArray.strToArrMapToInt();
        System.out.println(stringToArray);
        // Array of string to array of integer
        String[] strArray = {"10", "20", "30", "40", "50", "60", "100"};
        var arrayToArray = new StringToArray(strArray);
        arrayToArray.stringArrayToIntegerArray();
        System.out.println(arrayToArray);
        // Consecutive string to array
        String strConsecutive = "12345678910";
        var stringToArrayConsecutive = new StringToArray(strConsecutive);
        stringToArrayConsecutive.strToArrConsecutive();
        System.out.println(stringToArrayConsecutive);


    }
}
