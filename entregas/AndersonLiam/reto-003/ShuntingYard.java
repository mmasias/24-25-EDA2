import java.util.Scanner;
import java.util.Stack;

public class ShuntingYard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática en notación infija:");
        String expresionInfija = scanner.nextLine();
        System.out.println(shuntingYard(expresionInfija));
        scanner.close();
    }

    public static String shuntingYard(String expresionInfija) {
        Stack<Character> pila = new Stack<>();
        StringBuilder salida = new StringBuilder();
        char[] tokens = tokenizar(expresionInfija);

        for (char token : tokens) {
            if (token == ' ') continue; // Ignorar espacios

            if (esNumero(token)) {
                salida.append(token);
            } else if (esOperador(token)) {
                // Añadir espacio después de números
                if (salida.length() > 0 && esNumero(salida.charAt(salida.length() - 1))) {
                    salida.append(' ');
                }
                
                while (!pila.isEmpty() && esOperador(pila.peek()) && 
                       precedencia(pila.peek()) >= precedencia(token)) {
                    salida.append(pila.pop()).append(' ');
                }
                pila.push(token);
            } else if (token == '(') {
                pila.push(token);
            } else if (token == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(' ').append(pila.pop());
                }
                if (!pila.isEmpty()) {
                    pila.pop(); // Eliminar el '('
                }
            }
        }

        // Añadir espacio después del último número si es necesario
        if (salida.length() > 0 && esNumero(salida.charAt(salida.length() - 1))) {
            salida.append(' ');
        }

        // Vaciar la pila
        while (!pila.isEmpty()) {
            char operador = pila.pop();
            if (operador != '(') {
                salida.append(operador).append(' ');
            }
        }

        // Eliminar el último espacio si existe
        if (salida.length() > 0 && salida.charAt(salida.length() - 1) == ' ') {
            salida.setLength(salida.length() - 1);
        }

        return salida.toString();
    }

    private static char[] tokenizar(String expresionInfija) {
        return expresionInfija.toCharArray();
    }

    private static boolean esNumero(char caracter) {
        return Character.isDigit(caracter) || caracter == '.';
    }

    private static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || 
               caracter == '/' || caracter == '^';
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}