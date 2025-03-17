import java.util.*;

public class ShuntingYard {
    public static void shuntingYardPasoAPaso(List<String> expresionInfija) {
        List<String> salida = new ArrayList<>();
        List<String> pilaOperadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        for (String token : expresionInfija) {
            System.out.println("Token actual: " + token);
            
            if (esNumero(token)) {
                salida.add(token);
            } else if (esOperador(token)) {
                while (!pilaOperadores.isEmpty() && esOperador(pilaOperadores.get(pilaOperadores.size() - 1)) && 
                       precedencia(pilaOperadores.get(pilaOperadores.size() - 1)) >= precedencia(token)) {
                    salida.add(pilaOperadores.remove(pilaOperadores.size() - 1));
                }
                pilaOperadores.add(token);
            } else if (token.equals("(")) {
                pilaOperadores.add(token);
            } else if (token.equals(")")) {
                while (!pilaOperadores.isEmpty() && !pilaOperadores.get(pilaOperadores.size() - 1).equals("(")) {
                    salida.add(pilaOperadores.remove(pilaOperadores.size() - 1));
                }
                pilaOperadores.remove(pilaOperadores.size() - 1); // Eliminar '('
            }
            
            System.out.println("Pila de operadores: " + pilaOperadores);
            System.out.println("Salida: " + salida);
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
        }
        
        while (!pilaOperadores.isEmpty()) {
            salida.add(pilaOperadores.remove(pilaOperadores.size() - 1));
            System.out.println("Pila de operadores: " + pilaOperadores);
            System.out.println("Salida: " + salida);
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
        }
        
        System.out.println("Expresión en notación postfija: " + salida);
    }

    private static boolean esNumero(String token) {
        return token.matches("\\d+");
    }

    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }

    private static int precedencia(String operador) {
        switch (operador) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión matemática en notación infija, separando los elementos con espacios:");
        String input = scanner.nextLine();
        
        List<String> expresionInfija = Arrays.asList(input.split(" "));
        shuntingYardPasoAPaso(expresionInfija);
    }
}
