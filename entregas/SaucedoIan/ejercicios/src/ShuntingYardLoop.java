import java.util.Stack;

public class ShuntingYardLoop {
  private final Stack<String> operators;
  private final Stack<String> output;
  private final Stack<Double> evaluation;

  public ShuntingYardLoop() {
    operators = new Stack<>();
    output = new Stack<>();
    evaluation = new Stack<>();
  }

  public String infixToPostfix(String expression) {
    resetStacks();
    String[] tokens = expression.split(" ");
    processTokens(tokens);
    processRemainingOperators();
    return buildResult();
  }

  private void resetStacks() {
    operators.clear();
    output.clear();
    evaluation.clear();
  }

  private void processTokens(String[] tokens) {
    for (String token : tokens) {
      if (isNumber(token)) {
        output.push(token);
      } else if (isOperator(token)) {
        processOperator(token);
      } else if (token.equals("(")) {
        operators.push(token);
      } else if (token.equals(")")) {
        processRightParenthesis();
      }
    }
  }

  private void processOperator(String token) {
    while (!operators.isEmpty() &&
        isOperator(operators.peek()) &&
        getPrecedence(operators.peek()) >= getPrecedence(token)) {
      output.push(operators.pop());
    }
    operators.push(token);
  }

  private void processRightParenthesis() {
    while (!operators.isEmpty() && !operators.peek().equals("(")) {
      output.push(operators.pop());
    }
    if (!operators.isEmpty()) {
      operators.pop();
    }
  }

  private void processRemainingOperators() {
    while (!operators.isEmpty()) {
      String operator = operators.peek();
      if (!operator.equals("(")) {
        output.push(operators.pop());
      } else {
        operators.pop();
      }
    }
  }

  private String buildResult() {
    Stack<String> reversed = reverseStack(output);
    return stackToString(reversed);
  }

  private Stack<String> reverseStack(Stack<String> original) {
    Stack<String> reversed = new Stack<>();
    while (!original.isEmpty()) {
      reversed.push(original.pop());
    }
    return reversed;
  }

  private String stackToString(Stack<String> stack) {
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      result.append(stack.pop()).append(" ");
    }
    return result.toString().trim();
  }

  public double evaluate(String expression) {
    String postfix = infixToPostfix(expression);
    return evaluatePostfix(postfix.split(" "));
  }

  private double evaluatePostfix(String[] tokens) {
    evaluation.clear();
    for (String token : tokens) {
      if (isNumber(token)) {
        evaluation.push(Double.parseDouble(token));
      } else if (isOperator(token)) {
        processOperation(token);
      }
    }
    return evaluation.pop();
  }

  private void processOperation(String operator) {
    double operand2 = evaluation.pop();
    double operand1 = evaluation.pop();
    evaluation.push(calculate(operand1, operand2, operator));
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

  private double calculate(double a, double b, String operator) {
    return switch (operator) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "*" -> a * b;
      case "/" -> a / b;
      case "^" -> Math.pow(a, b);
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
  }
}