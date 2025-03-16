import java.util.Scanner;
import java.util.Stack;

class ShutingYard {
    public static void main(String[] args) {
        String input = intro();

        ShutingYard example1 = new ShutingYard();
        Stack<String> rpn = example1.InfijoAPostfijo(input);

        System.out.println(input);
        System.out.println(rpn);

    }

    Stack<String> InfijoAPostfijo(String input) {
        Stack<String> operadores = new Stack<>();
        Stack<String> salida = new Stack<>();

        String[] tokens = input.split("");

        for (int index = 0; index < tokens.length; index++) {
            String token = tokens[index];

            if (token.isNumber(token)) {
                salida.push(token);
            }

            if (token.isOp(token)) {
                do {
                    salida.push(operadores.peek());
                    operadores.pop();

                } while (!operadores.isEmpty() && isOp(operadores.peek()) && operadores.peek().priority()>=token.priority());
                
                operadores.push(token);
            }

            if (token.equals("(")) {
                salida.push(token);
            }

            if (token.equals(")")) {
                do {
                    salida.push(operadores.peek());
                    operadores.pop();

                } while (operadores.peek().equals("("));
                
                operadores.pop();
            }

            do {
                salida.push(operadores.peek());
                operadores.pop();
            } while (!operadores.isEmpty());
        }
        return salida;
    }

    static boolean isNumber(String token) {

    }

    static boolean isOp(String token) {
        

    }

    static int priority(){

    }

    static String intro() {
        System.out.println("Escribe la operacion a transformar: ");
        return new Scanner(System.in).nextLine();
    }
}
