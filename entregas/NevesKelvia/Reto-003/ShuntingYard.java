import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShuntingYard {
    public static List<String> shuntingYard(String[] expression) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("^", 3);
        
        for (String token : expression) {
            if (token.matches("\\d+")) { 
                output.add(token);
            } else if (precedence.containsKey(token)) { 
                while (!stack.isEmpty() && precedence.containsKey(stack.peek())
                        && precedence.get(stack.peek()) >= precedence.get(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) { 
                stack.push(token);
            } else if (token.equals(")")) { 
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop(); 
            }
        }
        
        while (!stack.isEmpty()) { 
            output.add(stack.pop());
        }
        
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática en notación infija (separada por espacios):");
        String input = scanner.nextLine();
        scanner.close();

        String[] expression = input.split(" ");
        List<String> result = shuntingYard(expression);
        System.out.println("Expresión en notación postfija: ");
        System.out.println(String.join(" ", result));
    }
}
