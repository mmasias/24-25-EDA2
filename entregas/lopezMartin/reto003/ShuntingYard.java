package entregas.lopezMartin.reto003;

import java.util.Scanner;
import java.util.Stack;

public class ShuntingYard {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática en notación infija:");
        String expresionInfija = sc.nextLine();
        
        System.out.println(shuntingYard(expresionInfija, sc));
    }
    
    public static String shuntingYard(String expresionInfija, Scanner sc) {
        Stack <Character> pila = new Stack<>();
        Stack <Character> salida = new Stack<>();
        char[] tokens = tokenizar(expresionInfija);

        for(int i = 0; i < tokens.length; i++) {
            System.out.println("Procesando token: " + tokens[i]);
            
            if (esNumero(tokens[i])) {
                salida.push(tokens[i]);
            } else {
                if (esOperador(tokens[i])) {
                    while(!pila.isEmpty() && esOperador(pila.peek()) && precedencia(pila.peek()) >= precedencia(tokens[i])) {
                        salida.push(pila.pop());
                    }
                    pila.push(tokens[i]);
                } else if (tokens[i] == '(') {
                    pila.push(tokens[i]);
                } else {
                    while (pila.peek() != '(') {
                        salida.push(pila.pop());
                    }
                    pila.pop();
                }
            }
            
            imprimirEstadoPilas(pila, salida);
            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();
        }

        while (!pila.isEmpty()) {
            salida.push(pila.pop());
            imprimirEstadoPilas(pila, salida);
            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();
        }

        String resultado = "";
        while (!salida.isEmpty()) {
            resultado = salida.pop() + resultado;
        }

        return resultado;
    }
    
    private static char[] tokenizar(String expresionInfija) {
        char[] caracteres = new char[expresionInfija.length()];
        for (int i = 0; i < expresionInfija.length(); i++) {
            caracteres[i] = expresionInfija.charAt(i);
        }
        return caracteres;
    }

    private static boolean esNumero(char caracter) {
        return caracter >= '0' && caracter <= '9';
    }

    private static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^';
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
    
    private static void imprimirEstadoPilas(Stack<Character> pila, Stack<Character> salida) {
        System.out.println("Pila de operadores: " + pila);
        System.out.println("Pila de salida: " + salida);
        System.out.println("----------------------");
    }
}
