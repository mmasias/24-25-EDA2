import java.util.Scanner;
import java.util.Stack;
public static String convertirPostfija(String expresion) {
    Stack<Character> operadores = new Stack<>();
    Stack<Character> salida = new Stack<>();
    char[] simbolos = extraerSimbolos(expresion);

    for (char simbolo : simbolos) {
        if (esDigito(simbolo)) {
            salida.push(simbolo);
        } else if (esSigno(simbolo)) {
            while (!operadores.isEmpty() && esSigno(operadores.peek()) && prioridad(operadores.peek()) >= prioridad(simbolo)) {
                salida.push(operadores.pop());
            }
            operadores.push(simbolo);
        } else if (simbolo == '(') {
            operadores.push(simbolo);
        } else if (simbolo == ')') {
            while (!operadores.isEmpty() && operadores.peek() != '(') {
                salida.push(operadores.pop());
            }
            operadores.pop();
        }
    }

    while (!operadores.isEmpty()) {
        salida.push(operadores.pop());
    }

    StringBuilder resultado = new StringBuilder();
    while (!salida.isEmpty()) {
        resultado.insert(0, salida.pop());
    }

    return resultado.toString();
}

public static double calcularResultado(String expresion) {
    Stack<Double> pila = new Stack<>();

    for (char simbolo : expresion.toCharArray()) {
        if (esDigito(simbolo)) {
            pila.push((double) (simbolo - '0'));
        } else if (esSigno(simbolo)) {
            double b = pila.pop();
            double a = pila.pop();
            pila.push(ejecutarOperacion(a, b, simbolo));
        }
    }
    return pila.pop();
}

private static double ejecutarOperacion(double a, double b, char signo) {
    switch (signo) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
        case '^': return Math.pow(a, b);
        default:
            System.out.println("Error: Signo inválido - " + signo);
            return 0; 
    }
}

private static char[] extraerSimbolos(String expresion) {
    return expresion.replaceAll(" ", "").toCharArray();
}

private static boolean esDigito(char c) {
    return c >= '0' && c <= '9';
}

private static boolean esSigno(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
}

private static int prioridad(char signo) {
    switch (signo) {
        case '+': case '-': return 1;
        case '*': case '/': return 2;
        case '^': return 3;
        default: return -1;
    }
}
