package entregas.lopezMartin.reto003;

import java.util.Scanner;

public class ShuntingYard {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión matemática en notación infija:");
        String expresionInfija = scanner.nextLine();
        
        System.out.println(shuntingYard(expresionInfija));
    }
    
    public static String shuntingYard(String expresionInfija) {
        String[] pila = new String[100];
        String[] salida = new String[100];
        int topeIndice = -1;
        int salidaIndice = 0;

        String[] tokens = tokenizar(expresionInfija);
        
        for (int i = 0; i < tokens.length && tokens[i] != null; i++) {
            String token = tokens[i];
            
            if (esNumero(token)) {
                salida[salidaIndice++] = token;
            } else if (esOperador(token)) {
                while (topeIndice >= 0 && esOperador(pila[topeIndice]) && 
                       obtenerPrecedencia(pila[topeIndice]) >= obtenerPrecedencia(token)) {
                    salida[salidaIndice++] = pila[topeIndice--];
                }
                pila[++topeIndice] = token;
            } else if (token.equals("(")) {
                pila[++topeIndice] = token;
            } else if (token.equals(")")) {
                while (topeIndice >= 0 && !pila[topeIndice].equals("(")) {
                    salida[salidaIndice++] = pila[topeIndice--];
                }
                if (topeIndice >= 0 && pila[topeIndice].equals("(")) {
                    topeIndice--;
                }
            }
        }
        
        while (topeIndice >= 0) {
            salida[salidaIndice++] = pila[topeIndice--];
        }
        
        return salida;
    }
    
    private static String[] tokenizar(String expresion) {
        String[] tokens = new String[100];
        int tokenIndice = 0;
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c >= '0' && c <= '9') {
                char[] numArray = new char[30];
                int numIndice = 0;
                
                while (i < expresion.length() && ((expresion.charAt(i) >= '0' && expresion.charAt(i) <= '9') || expresion.charAt(i) == '.')) {
                    numArray[numIndice++] = expresion.charAt(i);
                    i++;
                }
                i--;
                
                String numero = new String(numArray, 0, numIndice);
                tokens[tokenIndice++] = numero;
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')') {
                tokens[tokenIndice++] = String.valueOf(c);
            }
        }
        
        return tokens;
    }
    
    private static boolean esNumero(String token) {
        return !token.isEmpty() && Character.isDigit(token.charAt(0));
    }
    
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || 
               token.equals("/") || token.equals("^");
    }
    
    private static int obtenerPrecedencia(String operador) {
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