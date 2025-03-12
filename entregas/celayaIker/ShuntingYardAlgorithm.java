package entregas.celayaIker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ShuntingYardAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la expresión infija sin espacios (ejemplo: 3+4*2/(1-5)^2^3):");
        String input = scanner.nextLine();
        List<String> tokens = tokenizar(input);

        List<String> salida = shuntingYard(tokens);
        System.out.println("Salida final (notación postfix): " + String.join(" ", salida));
        scanner.close();
    }

    public static List<String> tokenizar(String expresion) {
        List<String> tokens = new ArrayList<>();
        StringBuilder numero = new StringBuilder();

        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                numero.append(c); 
            } else {
                if (numero.length() > 0) {
                    tokens.add(numero.toString());
                    numero.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }

        if (numero.length() > 0) {
            tokens.add(numero.toString());
        }
        return tokens;
    }

    public static List<String> shuntingYard(List<String> expresionInfija) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        for (String token : expresionInfija) {
            if (esNumero(token)) {
                salida.add(token);
            } else if (esOperador(token)) {
                while (!pila.isEmpty() && esOperador(pila.peek()) &&
                        precedencia(pila.peek()) >= precedencia(token)) {
                    salida.add(pila.pop());
                }
                pila.push(token);
            } else if (token.equals("(")) {
                pila.push(token);
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida.add(pila.pop());
                }
                if (!pila.isEmpty() && pila.peek().equals("(")) {
                    pila.pop();
                } else {
                    System.out.println("Error: paréntesis no balanceados.");
                    return new ArrayList<>();
                }
            }

            System.out.println("Token procesado: " + token);
            System.out.println("Pila de salida: " + salida);
            System.out.println("Pila de operadores: " + pila);
            System.out.println("-----------------------------");
        }

        while (!pila.isEmpty()) {
            if (pila.peek().equals("(")) {
                System.out.println("Error: paréntesis no balanceados.");
                return new ArrayList<>(); 
            }
            salida.add(pila.pop());
        }

        System.out.println("Pila final de salida: " + salida);
        System.out.println("Pila final de operadores: " + pila);

        return salida;
    }

    private static boolean esNumero(String token) {
        try {
            Double.parseDouble(token); 
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean esOperador(String token) {
        return "+-*/^".contains(token);
    }

    private static int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }
}
