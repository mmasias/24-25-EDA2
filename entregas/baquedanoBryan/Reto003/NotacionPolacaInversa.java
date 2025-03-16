package entregas.baquedanoBryan.Reto003;

import java.util.Stack;

class NotacionPolacaInversa {
    
    public static String infijaAPostfijaIterativo(String expresion) {
        StringBuilder salida = new StringBuilder();
        Stack<Character> pila = new Stack<>();
        
        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c)) {
                salida.append(c);
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop());
                }
                pila.pop();
            } else { 
                while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
                    salida.append(pila.pop());
                }
                pila.push(c);
            }
        }
        
        while (!pila.isEmpty()) {
            salida.append(pila.pop());
        }
        return salida.toString();
    }

    public static String infijaAPostfijaRecursiva(String expresion) {
        return convertir(expresion, 0, new Stack<>(), new StringBuilder());
    }

    private static String convertir(String exp, int i, Stack<Character> pila, StringBuilder salida) {
        if (i == exp.length()) {
            while (!pila.isEmpty()) salida.append(pila.pop());
            return salida.toString();
        }
        
        char c = exp.charAt(i);
        if (Character.isDigit(c)) {
            salida.append(c);
        } else if (c == '(') {
            pila.push(c);
        } else if (c == ')') {
            while (!pila.isEmpty() && pila.peek() != '(') salida.append(pila.pop());
            pila.pop();
        } else { 
            while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
                salida.append(pila.pop());
            }
            pila.push(c);
        }
        
        return convertir(exp, i + 1, pila, salida);
    }

    public static double evaluarPostfija(String expresion) {
        Stack<Double> pila = new Stack<>();
        
        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c)) {
                pila.push((double) (c - '0'));
            } else {
                double b = pila.pop();
                double a = pila.pop();
                if (c == '+') {
                    pila.push(a + b);
                } else if (c == '-') {
                    pila.push(a - b);
                } else if (c == '*') {
                    pila.push(a * b);
                } else if (c == '/') {
                    pila.push(a / b);
                }
            }
        }
        return pila.pop();
    }

    private static int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else {
            return -1;
        }
    }
}
