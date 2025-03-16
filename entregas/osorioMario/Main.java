import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "3 + 5 * ( 2 - 8 )";
        
        System.out.println("Expression: " + expression + "\n");
        
        ShuntingYard converter = new ShuntingYard();
        
        List<String> postfix = converter.convertToPostfix(expression);
        System.out.println("Postfix: " + String.join(" ", postfix));
        
        double result = converter.evaluatePostfix(postfix);
        System.out.println("Result: " + result);
        
        String[] testExpressions = {
            "5 + 3",
            "2 * ( 3 + 4 )",
            "10 / 2 - 3",
            "3 ^ 2 + 4 * ( 8 - 5 )"
        };
        
        System.out.println("\n--- Ejemplos + ---");
        for (String expr : testExpressions) {
            postfix = converter.convertToPostfix(expr);
            result = converter.evaluatePostfix(postfix);
            System.out.println("Infix: " + expr);
            System.out.println("Postfix: " + String.join(" ", postfix));
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}