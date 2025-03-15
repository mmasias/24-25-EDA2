import java.util.Stack;
import java.util.Scanner;

class Shunting {

    private static boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static int getPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '^')
            return 3;
        return -1;
    }

    private static boolean hasLeftAssociativity(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static String shuntingYard(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char token : expression.toCharArray()) {
            if (isLetterOrDigit(token)) {
                output.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                if (!processRightParenthesis(stack, output)) {
                    return "Expresión inválida";
                }
            } else {
                processOperator(token, stack, output);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Expresión inválida";
            }
            output.append(stack.pop());
        }

        return output.toString();
    }

    private static boolean processRightParenthesis(Stack<Character> stack, StringBuilder output) {
        while (!stack.isEmpty() && stack.peek() != '(') {
            output.append(stack.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
            return true;
        }
        return false;
    }

    private static void processOperator(char token, Stack<Character> stack, StringBuilder output) {
        while (!stack.isEmpty() && shouldPopOperator(token, stack.peek())) {
            output.append(stack.pop());
        }
        stack.push(token);
    }

    private static boolean shouldPopOperator(char current, char top) {
        int currentPrecedence = getPrecedence(current);
        int topPrecedence = getPrecedence(top);
        return currentPrecedence < topPrecedence ||
                (!hasLeftAssociativity(current) && currentPrecedence == topPrecedence);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática:");
        String expression = scanner.nextLine();
        System.out.println("Expresión en notación postfija: " + shuntingYard(expression));
        scanner.close();
    }
}
