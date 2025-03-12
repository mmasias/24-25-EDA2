import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "3 + 5 * ( 2 - 8 )";
        System.out.println("Expression: " + expression + "\n");

        List<String> postfixIterative = ShuntingYardIterative.convertToPostfix(expression);
        System.out.println("Iterative Postfix: " + String.join(" ", postfixIterative));

        List<String> postfixRecursive = ShuntingYardRecursive.convertToPostfix(expression);
        System.out.println("Recursive Postfix: " + String.join(" ", postfixRecursive));

        System.out.println("Results Match: " + postfixIterative.equals(postfixRecursive));
    }
}

