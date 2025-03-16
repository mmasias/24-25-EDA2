package entregas.Reyes_David.Reto_003;

import java.util.*;

public class ShutingYard {

    public static List<String> shuntingYard(List<String> expresionInfija) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();
        Map<String, Integer> precedencia = new HashMap<>();
        precedencia.put("+", 1);
        precedencia.put("-", 1);
        precedencia.put("*", 2);
        precedencia.put("/", 2);

        for (String token : expresionInfija) {
            if (isNumber(token)) {
                salida.add(token);
            } else if (isOperator(token)) {
                while (!pila.isEmpty() && isOperator(pila.peek()) &&
                        precedencia.get(pila.peek()) >= precedencia.get(token)) {
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
                }
            }
        }

        while (!pila.isEmpty()) {
            salida.add(pila.pop());
        }

        return salida;
    }

    private static boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private static boolean isOperator(String token) {
        return Arrays.asList("+", "-", "*", "/").contains(token);
    }

    private static List<String> tokenize(String expresion) {
        List<String> tokens = new ArrayList<>();
        StringBuilder numero = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isDigit(c)) {

                numero.append(c);
            } else {

                if (numero.length() > 0) {
                    tokens.add(numero.toString());
                    numero.setLength(0);
                }

                if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                    tokens.add(String.valueOf(c));
                }
            }
        }

        if (numero.length() > 0) {
            tokens.add(numero.toString());
        }

        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión aritmética en notación infija (por ejemplo, 3+4*2-1):");
        String entrada = scanner.nextLine();

        List<String> expresionInfija = tokenize(entrada);

        List<String> resultado = shuntingYard(expresionInfija);

        System.out.println("Notación Postfija: " + String.join(" ", resultado));

        scanner.close();
    }
}