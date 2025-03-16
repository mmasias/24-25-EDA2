import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class ShuntingYard {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("Ingrese expresión (ej: 3.5+4*(2-1)):");
            String expresion = entrada.nextLine();
            
            String[] postfija = convertirAPostfija(expresion);
            System.out.println("Postfija: " + String.join(" ", postfija));
            
            double resultado = calcularResultado(postfija);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            entrada.close();
        }
    }
    
    public static String[] convertirAPostfija(String expresion) {
        Stack<String> operadores = new Stack<>();
        ArrayList<String> salida = new ArrayList<>();
        ArrayList<String> tokens = tokenizar(expresion);
        
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            
            if (token.equals("-") && (i == 0 || tokens.get(i-1).equals("("))) {
                if (i + 1 < tokens.size() && esNumero(tokens.get(i+1))) {
                    salida.add("-" + tokens.get(i+1));
                    i++;
                    continue;
                }
            }
            
            if (esNumero(token)) {
                salida.add(token);
            } else if (esOperador(token)) {
                while (!operadores.isEmpty() && esOperador(operadores.peek()) &&
                       prioridad(operadores.peek()) >= prioridad(token)) {
                    salida.add(operadores.pop());
                }
                operadores.push(token);
            } else if (token.equals("(")) {
                operadores.push(token);
            } else if (token.equals(")")) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    salida.add(operadores.pop());
                }
                if (!operadores.isEmpty()) operadores.pop();
                else throw new RuntimeException("Paréntesis no balanceados");
            }
        }
        
        while (!operadores.isEmpty()) {
            String op = operadores.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new RuntimeException("Paréntesis no balanceados");
            }
            salida.add(op);
        }
        
        return salida.toArray(new String[0]);
    }
    
    private static ArrayList<String> tokenizar(String expresion) {
        ArrayList<String> tokens = new ArrayList<>();
        String exp = expresion.replaceAll("\\s+", "");
        StringBuilder num = new StringBuilder();
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            if (Character.isDigit(c) || c == '.') {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    tokens.add(num.toString());
                    num = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            }
        }
        
        if (num.length() > 0) {
            tokens.add(num.toString());
        }
        
        return tokens;
    }
    
    public static double calcularResultado(String[] expresion) {
        Stack<Double> pila = new Stack<>();
        
        for (String token : expresion) {
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else if (esOperador(token)) {
                if (pila.size() < 2) {
                    throw new RuntimeException("Expresión inválida: faltan operandos");
                }
                
                double b = pila.pop();
                double a = pila.pop();
                
                pila.push(ejecutarOperacion(a, b, token));
            }
        }
        
        if (pila.size() != 1) {
            throw new RuntimeException("Expresión inválida: sobran operandos");
        }
        
        return pila.pop();
    }
    
    private static double ejecutarOperacion(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? 
                        throw new ArithmeticException("División por cero") : a / b;
            case "^": return Math.pow(a, b);
            default: throw new RuntimeException("Operador desconocido: " + op);
        }
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
    
    private static int prioridad(String op) {
        return op.equals("+") || op.equals("-") ? 1 :
               op.equals("*") || op.equals("/") ? 2 :
               op.equals("^") ? 3 : -1;
    }
}