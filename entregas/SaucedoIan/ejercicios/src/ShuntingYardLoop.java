import java.util.Stack;

public class ShuntingYardLoop {
  private Stack<String> operators;
  private Stack<String> output;
  private Stack<Double> evaluation;

  public ShuntingYardLoop() {
    operators = new Stack<>();
    output = new Stack<>();
    evaluation = new Stack<>();
  }

  public String infixToPostfix(String expression) {
    String[] tokens = expression.split(" ");

    for (String token : tokens) {
      if (isNumber(token)) {
        output.push(token);
      } else if (isOperator(token)) {
        while (!operators.isEmpty() &&
            isOperator(operators.peek()) &&
            getPrecedence(operators.peek()) >= getPrecedence(token)) {
          output.push(operators.pop());
        }
        operators.push(token);
      } else if (token.equals("(")) {
        operators.push(token);
      } else if (token.equals(")")) {
        while (!operators.isEmpty() && !operators.peek().equals("(")) {
          output.push(operators.pop());
        }
        if (!operators.isEmpty()) {
          operators.pop();
        }
      }
    }

    while (!operators.isEmpty()) {
      if (!operators.peek().equals("(")) {
        output.push(operators.pop());
      } else {
        operators.pop();
      }
    }

    Stack<String> reversed = new Stack<>();
    while (!output.isEmpty()) {
      reversed.push(output.pop());
    }

    StringBuilder result = new StringBuilder();
    while (!reversed.isEmpty()) {
      result.append(reversed.pop()).append(" ");
    }

    return result.toString().trim();
  }

  private boolean isNumber(String token) {
    try {
      Double.parseDouble(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean isOperator(String token) {
    return token.matches("[+\\-*/^]");
  }

  private int getPrecedence(String operator) {
    return switch (operator) {
      case "+", "-" -> 1;
      case "*", "/" -> 2;
      case "^" -> 3;
      default -> 0;
    };
  }

  public double evaluate(String expression) {
    String postfix = infixToPostfix(expression);
    String[] tokens = postfix.split(" ");

    for (String token : tokens) {
      if (isNumber(token)) {
        evaluation.push(Double.parseDouble(token));
      } else if (isOperator(token)) {
        double b = evaluation.pop();
        double a = evaluation.pop();
        evaluation.push(calculate(a, b, token));
      }
    }

    return evaluation.pop();
  }

  private double calculate(double a, double b, String operator) {
    switch (operator) {
      case "+" -> {
        return a + b;
      }
      case "-" -> {
        return a - b;
      }
      case "*" -> {
        return a * b;
      }
      case "/" -> {
        return a / b;
      }
      case "^" -> {
        return Math.pow(a, b);
      }
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }
}