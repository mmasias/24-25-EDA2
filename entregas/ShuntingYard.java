import java.util.Scanner;
import java.util.Stack;

public class ShuntingYard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an infix expression:");
        String infixExpression = scanner.nextLine();

        String postfixExpression = convertToPostfix(infixExpression);
        System.out.println("Postfix notation: " + postfixExpression);

        double result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);

        scanner.close();
    }

    public static String convertToPostfix(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> output = new Stack<>();
        char[] symbols = extractSymbols(expression);

        for (char symbol : symbols) {
            if (isDigit(symbol)) {
                output.push(symbol);
            } else if (isOperator(symbol)) {
                while (!operators.isEmpty() && isOperator(operators.peek()) && precedence(operators.peek()) >= precedence(symbol)) {
                    output.push(operators.pop());
                }
                operators.push(symbol);
            } else if (symbol == '(') {
                operators.push(symbol);
            } else if (symbol == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.push(operators.pop());
                }
                operators.pop();
            }
            printStackStates(operators, output);
        }

        while (!operators.isEmpty()) {
            output.push(operators.pop());
            printStackStates(operators, output);
        }

        StringBuilder result = new StringBuilder();
        while (!output.isEmpty()) {
            result.insert(0, output.pop());
        }

        return result.toString();
    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();

        for (char symbol : expression.toCharArray()) {
            if (isDigit(symbol)) {
                stack.push((double) (symbol - '0'));
            } else if (isOperator(symbol)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = performOperation(a, b, symbol);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static double performOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            case '^': return Math.pow(a, b);
            default:
                System.out.println("Error: Invalid operator - " + operator);
                System.exit(1);
                return 0; 
        }
    }

    private static char[] extractSymbols(String expression) {
        return expression.replaceAll(" ", "").toCharArray();
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    private static void printStackStates(Stack<Character> operators, Stack<Character> output) {
        System.out.println("Operator stack: " + operators);
        System.out.println("Output stack: " + output);
        System.out.println("----------------------");
    }
}