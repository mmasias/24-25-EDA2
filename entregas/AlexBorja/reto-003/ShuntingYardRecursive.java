import java.util.*;

class ShuntingYardRecursive {
    private static int index;
    private static String[] tokens;

    public static List<String> convertToPostfix(String expression) {
        tokens = expression.split("\\s+");
        index = 0;
        return parseExpression();
    }

    private static List<String> parseExpression() {
        List<String> output = parseTerm();

        while (index < tokens.length && (tokens[index].equals("+") || tokens[index].equals("-"))) {
            String operator = tokens[index++];
            output.addAll(parseTerm());
            output.add(operator);
        }
        return output;
    }

    private static List<String> parseTerm() {
        List<String> output = parseFactor();

        while (index < tokens.length && (tokens[index].equals("*") || tokens[index].equals("/"))) {
            String operator = tokens[index++];
            output.addAll(parseFactor());
            output.add(operator);
        }
        return output;
    }

    private static List<String> parseFactor() {
        List<String> output = new ArrayList<>();

        if (tokens[index].matches("\\d+")) {
            output.add(tokens[index++]);
        } else if (tokens[index].equals("(")) {
            index++;
            output.addAll(parseExpression());
            index++; // Skip ')'
        }
        return output;
    }
}

