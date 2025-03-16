import java.util.*;

public class ShuntingYard {
    public static List<String> convertToPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    output.add(number.toString());
                    number = new StringBuilder();
                }
                if (c == ' ')
                    continue;

                String token = String.valueOf(c);
                if (isOperator(token)) {
                    while (!stack.isEmpty() && isOperator(stack.peek())
                            && precedence(stack.peek()) >= precedence(token)) {
                        output.add(stack.pop());
                    }
                    stack.push(token);
                } else if (token.equals("(")) {
                    stack.push(token);
                } else if (token.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        output.add(stack.pop());
                    }
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("Paréntesis desbalanceados");
                    }
                    stack.pop(); // Eliminar el "("
                }
            }
        }

        if (number.length() > 0) {
            output.add(number.toString());
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                throw new IllegalArgumentException("Paréntesis desbalanceados");
            }
            output.add(stack.pop());
        }

        return output;
    }

    private static boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    public static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0)
                            throw new ArithmeticException("División por cero");
                        stack.push(a / b);
                        break;
                    case "^":
                        stack.push(Math.pow(a, b));
                        break;
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
}
