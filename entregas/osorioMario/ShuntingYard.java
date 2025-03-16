import java.util.*;

public class ShuntingYard {
    
    private final Map<String, Integer> precedence;
    private final Set<String> operators;
    
    public ShuntingYard() {
        precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("^", 3);
        
        operators = new HashSet<>(precedence.keySet());
    }
    
    public List<String> convertToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();
        
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                output.add(token);
            }
            else if (token.equals("(")) {
                operatorStack.push(token);
            }
            else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.add(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                } else {
                    throw new IllegalArgumentException("Paréntesis desbalanceados");
                }
            }
            else if (operators.contains(token)) {
                while (!operatorStack.isEmpty() && 
                       operators.contains(operatorStack.peek()) && 
                       precedence.get(operatorStack.peek()) >= precedence.get(token)) {
                    output.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
            else {
                throw new IllegalArgumentException("Token desconocido: " + token);
            }
        }
        
        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            if (op.equals("(")) {
                throw new IllegalArgumentException("Paréntesis desbalanceados");
            }
            output.add(op);
        }
        
        return output;
    }
    
    public double evaluatePostfix(List<String> postfixExpression) {
        Stack<Double> valueStack = new Stack<>();
        
        for (String token : postfixExpression) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                valueStack.push(Double.parseDouble(token));
            }
            else if (operators.contains(token)) {
                if (valueStack.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfija inválida");
                }
                
                double b = valueStack.pop();
                double a = valueStack.pop();
                
                double result;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        result = a / b;
                        break;
                    case "^":
                        result = Math.pow(a, b);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + token);
                }
                
                valueStack.push(result);
            }
            else {
                throw new IllegalArgumentException("Token desconocido en evaluación: " + token);
            }
        }
        
        if (valueStack.size() != 1) {
            throw new IllegalArgumentException("Expresión postfija inválida");
        }
        
        return valueStack.pop();
    }
}