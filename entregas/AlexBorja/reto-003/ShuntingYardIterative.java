import java.util.*;

class ShuntingYardIterative {
    public static List<String> convertToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        String[] tokens = expression.split("\\s+");

        Map<String, Integer> precedence = Map.of("+", 1, "-", 1, "*", 2, "/", 2);
        Set<String> operatorsSet = Set.of("+", "-", "*", "/", "^");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                output.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop(); // Remove '('
            } else if (operatorsSet.contains(token)) { // If it's an operator
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }
}

