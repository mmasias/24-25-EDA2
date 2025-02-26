package EjerciciosAlgoritmos;

public class ArrayRotado {

    public static int encontrarPuntoRotacion(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] > array[fin]) {
                inicio = medio + 1; 
            } else {
                fin = medio; 
            }
        }
        return inicio;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 2, 3};
        int resultado = encontrarPuntoRotacion(array);
        System.out.println("El punto de rotación está en el índice: " + resultado);
    }
}