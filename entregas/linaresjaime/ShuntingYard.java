import java.util.Scanner;

public class ShuntingYard {
    public static String shuntingYard(String expresion) {
        return procesarTokens(expresion, "", "", 0);
    }

    private static String procesarTokens(String expresion, String pila, String salida, int index) {
        if (index >= expresion.length()) {
            return vaciarPila(pila, salida);
        }

        char token = expresion.charAt(index);

        if (Character.isDigit(token)) {
            salida += token;
        } else if (esOperador(token)) {
            while (!pila.isEmpty() && esOperador(pila.charAt(pila.length() - 1)) && 
                   precedencia(pila.charAt(pila.length() - 1)) >= precedencia(token)) {
                salida += pila.charAt(pila.length() - 1);
                pila = pila.substring(0, pila.length() - 1);
            }
            pila += token;
        } else if (token == '(') {
            pila += token;
        } else if (token == ')') {
            while (!pila.isEmpty() && pila.charAt(pila.length() - 1) != '(') {
                salida += pila.charAt(pila.length() - 1);
                pila = pila.substring(0, pila.length() - 1);
            }
            pila = pila.substring(0, pila.length() - 1);
        }

        return procesarTokens(expresion, pila, salida, index + 1);
    }

    private static String vaciarPila(String pila, String salida) {
        if (pila.isEmpty()) {
            return salida;
        }
        salida += pila.charAt(pila.length() - 1);
        return vaciarPila(pila.substring(0, pila.length() - 1), salida);
    }

    private static boolean esOperador(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    private static int precedencia(char operador) {
        return switch (operador) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una expresión en notación infija: ");
        String expresion = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Notación postfija: " + shuntingYard(expresion));
        scanner.close();
    }
}
