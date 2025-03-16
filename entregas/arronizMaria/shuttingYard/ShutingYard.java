import java.util.Scanner;
import java.util.Stack;

class ShutingYard {
    public static void main(String[] args) {
        String input = intro();
        System.out.println("Operación en infijo: " + input);

        ShutingYard example1 = new ShutingYard();
        example1.InfijoAPostfijo(input);
    }

    void InfijoAPostfijo(String input) {
        Stack<String> operadores = new Stack<>();
        Stack<String> salida = new Stack<>();

        String[] tokens = input.split("");

        for (int index = 0; index < tokens.length; index++) {
            String token = tokens[index];

            if (isNumber(token)) {
                salida.push(token);
            }

            if (isOp(token)) {
                while (!operadores.isEmpty() && isOp(operadores.peek()) && priority(operadores.peek()) <= priority(token)) {
                    salida.push(operadores.peek());
                    operadores.pop();
                }
                operadores.push(token);
            }

            if (token.equals("(")) {
                operadores.push(token);
            }

            if (token.equals(")")) {
                if (!operadores.isEmpty()) {
                    salida.push(operadores.peek());
                    operadores.pop();
                }
                while (!operadores.isEmpty() && operadores.peek().equals("(")) {
                    operadores.pop();
                }
            }
        }

        while (!operadores.isEmpty()) {
            salida.push(operadores.peek());
            operadores.pop();
        }

        System.out.println("Operación en postfijo: " + salida);
    }

    static boolean isNumber(String token) {
        return token.equals("0") || token.equals("1") || token.equals("2") || token.equals("3") || token.equals("4")
                || token.equals("5") || token.equals("6") || token.equals("7") || token.equals("8")
                || token.equals("9");

    }

    static boolean isOp(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    static int priority(String token) {
        switch (token) {
            case "/":
                return 3;
            case "*":
                return 2;
            case "+":
                return 1;
            case "-":
                return 1;
        }

        return 0;

    }

    @SuppressWarnings("resource")
    static String intro() {
        System.out.println("Escribe la operacion a transformar: ");
        return new Scanner(System.in).nextLine();
    }
}
