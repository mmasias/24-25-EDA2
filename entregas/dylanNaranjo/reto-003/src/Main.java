import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una expresión infija:");
        String infixExpression = scanner.nextLine();
        List<String> postfixExpression = ShuntingYard.convertToPostfix(infixExpression);
        System.out.println("Expresión Infija: " + infixExpression);
        System.out.println("Expresión Postfija: " + postfixExpression);
    }
}