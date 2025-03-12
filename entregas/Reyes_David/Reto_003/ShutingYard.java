import java.util.*;

public class ShuntingYard {

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

    public static void main(String[] args) {
        
        List<String> expresionInfija = Arrays.asList("3", "+", "4", "*", "2", "-", "1");
        List<String> resultado = shuntingYard(expresionInfija);
        System.out.println("Postfix: " + String.join(" ", resultado)); 
    }
}