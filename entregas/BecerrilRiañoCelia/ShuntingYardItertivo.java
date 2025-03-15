package BecerrilRiañoCelia;

import java.util.*;

public class ShuntingYardItertivo {

    public static List<String> convertirInfijaAPostfija(String[] tokens) {
        List<String> salida = new ArrayList<>();
        Stack<String> pila = new Stack<>();

        System.out.println("Expresión infija: " + String.join(" ", tokens));

        for (String token : tokens) {
            if (esNumerico(token)) {
                salida.add(token);
            } else if (token.equals("(")) {
                pila.push(token);
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida.add(pila.pop());
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && precedencia(pila.peek()) >= precedencia(token)) {
                    salida.add(pila.pop());
                }
                pila.push(token);
            }
            System.out.println("Operador: " + token);
            System.out.println("Pila: " + pila);
            System.out.println("Salida: " + salida);
        }

        while (!pila.isEmpty()) {
            salida.add(pila.pop());
        }

        
        return salida;
    }

    private static boolean esNumerico(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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

    private static String agregarEspacios(String entrada) {
        return entrada.replaceAll("([\\d.]+|[^\\d.])", " $1 ").trim().replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la expresión infija: ");
        String entrada = scanner.nextLine();
        String[] expresion = agregarEspacios(entrada).split(" ");
        List<String> resultado = convertirInfijaAPostfija(expresion);
        System.out.println("Expresión postfija: " + String.join(" ", resultado));
    }
}