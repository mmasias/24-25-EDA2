import java.util.*;

public class ShuntingYard {
    public static List<String> convertToPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        String[] tokens = infix.split(" ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Paso a paso del algoritmo Shunting Yard:");
        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            }
            printState(token, stack, output);
            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
            printState("Final", stack, output);
            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        }

        return output;
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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

    private static void printState(String token, Stack<String> stack, List<String> output) {
        System.out.println("Token: " + token);
        System.out.println("Pila: " + stack);
        System.out.println("Salida: " + output);
        System.out.println("-------------------------");
    }
}