package Stack;

import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        System.out.println(isValid("()[]"));

    }

    public static boolean isValid(String bracket) {
        var stack = new Stack<Character>();
//        for (int i = 0; i < bracket.length(); i++) {
//            if (bracket.charAt(i) == '(' || bracket.charAt(i) == '[') {
//                stack.push(bracket.charAt(i));
//                continue;
//
//            }
//            if (stack.isEmpty()) {
//                return false;
//
//            }
//            if ((bracket.charAt(i) == ')' && stack.pop() != '(') || (bracket.charAt(i) == ']' && stack.pop() != '[')) {
//                return false;
//
//            }
//        }
        var bracketArray = bracket.toCharArray();
        for (char parathese : bracketArray) {
            if (parathese == '(' || parathese == '[') {
                stack.push(parathese);
                continue;

            }
            if (stack.isEmpty()) {
                return false;

            }
            if ((parathese == ')' && stack.pop() != '(') || (parathese == ']' && stack.pop() != '[')) {
                return false;

            }

        }
        return stack.isEmpty();

    }
}
