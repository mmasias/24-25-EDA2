import java.util.Stack;

public class ShuntingYardRecursive {
  private final Stack<String> operators;
  private final Stack<String> output;
  private final Stack<Double> evaluation;

  public ShuntingYardRecursive() {
    operators = new Stack<>();
    output = new Stack<>();
    evaluation = new Stack<>();
  }

  public String infixToPostfix(String expression) {
    resetStacks();
    String[] tokens = expression.split(" ");
    processTokens(tokens, 0);
    processRemainingOperators();
    return buildResult();
  }

  private void resetStacks() {
    operators.clear();
    output.clear();
    evaluation.clear();
  }

  private void processTokens(String[] tokens, int index) {
    if (index >= tokens.length) {
      return;
    }

    String token = tokens[index];
    processToken(token);
    processTokens(tokens, index + 1);
  }

  private void processToken(String token) {
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

  private void processOperator(String token) {
    if (!operators.isEmpty()) {
      processOperatorPrecedence(token);
    }
    operators.push(token);
  }

  private void processOperatorPrecedence(String token) {
    if (operators.isEmpty()) {
      return;
    }

    if (isOperator(operators.peek()) &&
        getPrecedence(operators.peek()) >= getPrecedence(token)) {
      output.push(operators.pop());
      processOperatorPrecedence(token);
    }
  }

  private void processRightParenthesis() {
    processUntilLeftParenthesis();
    removeLeftParenthesis();
  }

  private void processUntilLeftParenthesis() {
    while (!operators.isEmpty() && !operators.peek().equals("(")) {
      output.push(operators.pop());
    }
  }

  private void removeLeftParenthesis() {
    if (!operators.isEmpty()) {
      operators.pop();
    }
  }

  private void processRemainingOperators() {
    if (operators.isEmpty()) {
      return;
    }

    processNextOperator();
    processRemainingOperators();
  }

  private void processNextOperator() {
    if (!operators.peek().equals("(")) {
      output.push(operators.pop());
    } else {
      operators.pop();
    }
  }

  private String buildResult() {
    Stack<String> reversed = reverseStack(output);
    return stackToString(reversed);
  }

  private Stack<String> reverseStack(Stack<String> stack) {
    if (stack.isEmpty()) {
      return new Stack<>();
    }
    String item = stack.pop();
    Stack<String> reversed = reverseStack(stack);
    reversed.push(item);
    return reversed;
  }

  private String stackToString(Stack<String> stack) {
    if (stack.isEmpty()) {
      return "";
    }
    String item = stack.pop();
    String result = stackToString(stack);
    return result.isEmpty() ? item : result + " " + item;
  }

  public double evaluate(String expression) {
    String postfix = infixToPostfix(expression);
    return evaluatePostfix(postfix.split(" "), 0);
  }

  private double evaluatePostfix(String[] tokens, int index) {
    if (index >= tokens.length) {
      return evaluation.pop();
    }

    String token = tokens[index];
    processPostfixToken(token);
    return evaluatePostfix(tokens, index + 1);
  }

  private void processPostfixToken(String token) {
    if (isNumber(token)) {
      evaluation.push(Double.parseDouble(token));
    } else if (isOperator(token)) {
      processPostfixOperation(token);
    }
  }

  private void processPostfixOperation(String operator) {
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