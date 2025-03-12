import java.util.Scanner;

public class ShuntingYard {
    public static String[] shuntingYard(String[] expresion) {
        Pila pila = new Pila();
        String[] salida = new String[expresion.length];
        int indiceSalida = 0;
        
        for (String token : expresion) {
            if (token.matches("\\d+")) {
                salida[indiceSalida++] = token;
            } else if (esOperador(token)) {
                while (!pila.estaVacia() && esOperador(pila.cima()) && 
                        precedencia(pila.cima()) >= precedencia(token)) {
                    salida[indiceSalida++] = pila.desapilar();
                }
                pila.apilar(token);
            } else if (token.equals("(")) {
                pila.apilar(token);
            } else if (token.equals(")")) {
                while (!pila.estaVacia() && !pila.cima().equals("(")) {
                    salida[indiceSalida++] = pila.desapilar();
                }
                pila.desapilar();
            }
        }
        
        while (!pila.estaVacia()) {
            salida[indiceSalida++] = pila.desapilar();
        }
        
        return limpiarSalida(salida, indiceSalida);
    }
    
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int precedencia(String operador) {
        if (operador.equals("+") || operador.equals("-")) return 1;
        if (operador.equals("*") || operador.equals("/")) return 2;
        return 0;
    }
    
    private static String[] limpiarSalida(String[] salida, int longitud) {
        String[] resultado = new String[longitud];
        System.arraycopy(salida, 0, resultado, 0, longitud);
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión infija separada por espacios:");
        String input = scanner.nextLine();
        scanner.close();
        
        String[] infixExpression = input.split(" ");
        String[] postfixExpression = shuntingYard(infixExpression);
        
        System.out.println("Expresión en notación postfija:");
        for (String token : postfixExpression) {
            System.out.print(token + " ");
        }
        System.out.println();
    }
}