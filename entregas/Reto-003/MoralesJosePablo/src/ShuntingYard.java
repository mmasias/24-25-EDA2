import java.util.Scanner;
import java.util.Stack;

public class ShuntingYard {
    public static String infixToPostfix(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<String> operators = new Stack<>();
        
        String[] tokens = formatExpression(expression).split(" ");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                output.append(token).append(" ");
            } else if (token.equals("(")) {
                operators.push(token);

            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.append(operators.pop()).append(" ");
                }
                operators.pop();

            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.append(operators.pop()).append(" ");
                }
                operators.push(token);
            }
        }
        
        while (!operators.isEmpty()) {
            output.append(operators.pop()).append(" ");
        }
        
        return output.toString().trim();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int precedence(String token) {
        return switch (token) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }

    private static String formatExpression(String expression) {
        return expression.replaceAll("([\\d.]+|[^\\d.])", " $1 ")
                .trim()
                .replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la expresión infija: ");
        String infixExpression = scanner.nextLine();
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Expresión postfija: " + postfixExpression);
    }
}