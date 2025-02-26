package Nivel2;

public class ArrayRotado {
    public static int encontrarPuntoRotacion(int[] numeros) {
        int inicio = 0;
        int fin = numeros.length - 1;
        
        while (inicio < fin) {
            int medio = (inicio + fin) / 2;
            if (numeros[medio] > numeros[fin]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        
        return inicio; 
    }

    public static void main(String[] args) {
        int[] numeros = {4, 5, 6, 1, 2, 3};
        int rotacion = encontrarPuntoRotacion(numeros);
        System.out.println("Punto de rotación: " + rotacion);
    }
}

