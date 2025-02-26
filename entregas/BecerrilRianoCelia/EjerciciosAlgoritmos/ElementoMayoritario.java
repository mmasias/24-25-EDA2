package EjerciciosAlgoritmos;

public class ElementoMayoritario {

    public static int encontrarElementoMayoritario(int[] array) {
        int n = array.length;
        int candidato = array[n / 2];

        
        int primeraPosicion = encontrarPrimeraPosicion(array, candidato);
        int ultimaPosicion = encontrarUltimaPosicion(array, candidato);

        if (ultimaPosicion - primeraPosicion + 1 > n / 2) {
            return candidato;
        } else {
            return -1; 
        }
    }

    private static int encontrarPrimeraPosicion(int[] array, int objetivo) {
        int inicio = 0, fin = array.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (array[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }

    private static int encontrarUltimaPosicion(int[] array, int objetivo) {
        int inicio = 0, fin = array.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio + 1) / 2;
            if (array[medio] > objetivo) {
                fin = medio - 1;
            } else {
                inicio = medio;
            }
        }
        return inicio;
    }

    public static void main(String[] args) {
        int[] arrayay = {1, 1, 1, 1, 2, 2, 3};
        int resultado = encontrarElementoMayoritario(arrayay);
        if (resultado != -1) {
            System.out.println("El elemento mayoritario es: " + resultado);
        } else {
            System.out.println("No hay elemento mayoritario.");
        }
    }
}