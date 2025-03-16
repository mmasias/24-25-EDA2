package entregas.martinezDiego.reto003;

public class ShuntingYard {

    public static void main(String[] args) {
        ShuntingYard shuntingYard = new ShuntingYard();
        String expresionInicial = "3+4*2/(1-5)^2^3";
        String resultado = shuntingYard.convertirExpresion(expresionInicial);
        System.out.println("Expresión convertida: " + resultado);
    }

    public String convertirExpresion(String expresion) {
        String resultado = "";
        int longitud = expresion.length();

        for(int i = 0; i < longitud; i++) {
            char caracter = expresion.charAt(i);

            if (caracter >= '0' && caracter <= '9') {
                resultado += caracter;
            } else if (caracter == '(') {
                apilar(caracter);
            } else if (caracter == ')') {
                while (!pilaVacia() && cima() != '(') {
                    resultado += desapilar();
                }
                desapilar();
            } else {
                while (!pilaVacia() && prioridad(cima()) >= prioridad(caracter)) {
                    resultado += desapilar();
                }
                apilar(caracter);
            }
        }

        while (!pilaVacia()) {
            resultado += desapilar();
        }

        return resultado;
    }

    public int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else if (operador == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    private char[] pila = new char[100];
    private int tope = -1;

    public void apilar(char operador) {
        pila[++tope] = operador;
    }

    public char desapilar() {
        return pila[tope--];
    }

    public char cima() {
        return pila[tope];
    }

    public boolean pilaVacia() {
        return tope == -1;
    }
}


