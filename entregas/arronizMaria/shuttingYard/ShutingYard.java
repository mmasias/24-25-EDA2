import java.util.Scanner;
import java.util.Stack;

class ShutingYard {
    public static void main(String[] args) {
        String input = intro();

        ShutingYard example1 = new ShutingYard();
        example1.InfijoAPostfijo(input);
    }

    void InfijoAPostfijo(String input) {
        Stack<String> operadores = new Stack<>();
        Stack<String> salida = new Stack<>();

        String[] tokens = input.split("");

        for (int index = 0; index < tokens.length; index++) {

            String token = tokens[index];

            if (token.isNumber(token)) {
                salida.push(token);
            } else {
                while(!operadores.isEmpty() && operadores.peek().isOp() && ){
                    salida.push(operadores.peek());
                    operadores.pop(operadores.peek());
                }
                operadores.push(token);
            }

            if (token == "(") {
                salida.push(token);
            }

            if (token == ")") {
                while (salida.peek() != "(") {

                }

            }

        }
    }

    static boolean isNumber(String token) {

    }

    static boolean isOp() {

    }

    static String intro() {
        System.out.println("Escribe la operacion a transformar: ");
        return new Scanner(System.in).nextLine();
    }
}
