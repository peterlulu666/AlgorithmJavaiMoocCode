package Stack;

import java.util.Stack;

public class ParatheseCheck {
    public static void main(String[] args) {
        // ()[]{}
        // {[()]}
        System.out.println(isValid("()[])"));

    }

    public static boolean isValid(String parathese) {
        var stack = new Stack<Character>();
        int countPush = 0;
        int countIteration = 0;
        for (int i = 0; i < parathese.length(); i++) {
            countIteration++;
            if (parathese.charAt(i) == '(' ||
                    parathese.charAt(i) == '[' ||
                    parathese.charAt(i) == '{') {
                stack.push(parathese.charAt(i));
                countPush++;
                continue;

            }
            if (stack.empty()){
                return false;

            }
            char stackPop = stack.pop();
            if (stackPop == '(' && parathese.charAt(i) != ')') {
                return false;

            }
            if (stackPop == '[' && parathese.charAt(i) != ']') {
                return false;

            }
            if (stackPop == '{' && parathese.charAt(i) != '}') {
                return false;

            }

            if (stack.empty() && countPush == parathese.length() / 2) {
                return true;

            }



//            if (stack.empty() && countIteration == parathese.length()) {
//                return true;
//
//            }

        }
        return false;

    }
}
