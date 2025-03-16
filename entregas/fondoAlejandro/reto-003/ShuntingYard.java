import java.util.Scanner;

public class ShuntingYard {
    public static String convertirAPostfija(String expresion) {
        char[] caracteres = expresion.toCharArray();
        String[] pila = new String[caracteres.length];
        String[] salida = new String[caracteres.length];
        int topePila = -1, topeSalida = 0;

        String operadores = "+-*/";
        int[] precedencia = {1, 1, 2, 2};

        String token = "";
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < caracteres.length; i++) {
            char caracterActual = caracteres[i];
            if (caracterActual >= '0' && caracterActual <= '9') {
                token += caracterActual;
                if (i == caracteres.length - 1 || !(caracteres[i + 1] >= '0' && caracteres[i + 1] <= '9')) {
                    salida[topeSalida++] = token;
                    System.out.println("Se añade a salida: " + token);
                    scanner.nextLine();
                    token = "";
                }
            } else if (operadores.indexOf(caracterActual) != -1) {
                while (topePila >= 0 && operadores.indexOf(pila[topePila]) != -1 &&
                        precedencia[operadores.indexOf(pila[topePila])] >= precedencia[operadores.indexOf(caracterActual)]) {
                    System.out.println("Se mueve de pila a salida: " + pila[topePila]);
                    salida[topeSalida++] = pila[topePila--];
                    scanner.nextLine();
                }
                pila[++topePila] = String.valueOf(caracterActual);
                System.out.println("Se añade a pila: " + caracterActual);
                scanner.nextLine();
            } else if (caracterActual == '(') {
                pila[++topePila] = String.valueOf(caracterActual);
                System.out.println("Se añade a pila: " + caracterActual);
                scanner.nextLine();
            } else if (caracterActual == ')') {
                while (topePila >= 0 && !pila[topePila].equals("(")) {
                    System.out.println("Se mueve de pila a salida: " + pila[topePila]);
                    salida[topeSalida++] = pila[topePila--];
                    scanner.nextLine();
                }
                System.out.println("Se elimina de pila: (");
                topePila--;
                scanner.nextLine();
            }
        }

        while (topePila >= 0) {
            System.out.println("Se mueve de pila a salida: " + pila[topePila]);
            salida[topeSalida++] = pila[topePila--];
            scanner.nextLine();
        }

        String resultado = "";
        for (int i = 0; i < topeSalida; i++) {
            resultado += salida[i] + " ";
        }
        
        if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) == ' ') {
            resultado = resultado.substring(0, resultado.length() - 1);
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión en notación infija sin espacios:");
        String expresion = scanner.nextLine();
        System.out.println("Expresión en notación postfija: " + convertirAPostfija(expresion));
    }
}
