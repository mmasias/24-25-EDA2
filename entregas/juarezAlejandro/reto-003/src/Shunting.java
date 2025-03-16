import java.util.*;

public class Shunting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la expresión infija: ");
        String entrada = scanner.nextLine();
        String[] tokens = formatearExpresion(entrada).split(" ");
        List<String> resultado = convertirAPostfija(tokens);
        System.out.println("Expresión postfija: " + String.join(" ", resultado));
        System.out.println("Resultado: " + evaluarPostfija(resultado));
    }

    public static List<String> convertirAPostfija(String[] tokens) {
        List<String> salida = new ArrayList<>();
        Stack<String> operadores = new Stack<>();

        System.out.println("Expresión infija: " + String.join(" ", tokens));

        for (String token : tokens) {
            if (esNumero(token)) {
                salida.add(token);
            } else if (token.equals("(")) {
                operadores.push(token);
            } else if (token.equals(")")) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    salida.add(operadores.pop());
                }
                operadores.pop();
            } else {
                while (!operadores.isEmpty() && prioridad(operadores.peek()) >= prioridad(token)) {
                    salida.add(operadores.pop());
                }
                operadores.push(token);
            }

            System.out.println("Token: " + token);
            System.out.println("Pila: " + operadores);
            System.out.println("Salida: " + salida);
        }

        while (!operadores.isEmpty()) {
            salida.add(operadores.pop());
        }

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

    private static int prioridad(String operador) {
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

    private static String formatearExpresion(String expresion) {
        return expresion.replaceAll("([\\d.]+|[^\\d.])", " $1 ")
                .trim()
                .replaceAll("\\s+", " ");
    }

    private static double evaluarPostfija(List<String> expresionPostfija) {
        Stack<Double> pila = new Stack<>();

        for (String token : expresionPostfija) {
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else {
                double b = pila.pop();
                double a = pila.pop();
                switch (token) {
                    case "+":
                        pila.push(a + b);
                        break;
                    case "-":
                        pila.push(a - b);
                        break;
                    case "*":
                        pila.push(a * b);
                        break;
                    case "/":
                        pila.push(a / b);
                        break;
                    case "^":
                        pila.push(Math.pow(a, b));
                        break;
                }
            }
        }
        return pila.pop();
    }
}
