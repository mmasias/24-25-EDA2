package EjerciciosAlgoritmos;

public class Montaña {

    public static boolean esMontaña(int[] array) {
        if (array.length < 3) {
            return false;
        }

        int indice = 0;

        while (indice + 1 < array.length && array[indice] < array[indice + 1]) {
            indice++;
        }

        if (indice == 0 || indice == array.length - 1) {
            return false;
        }

        while (indice + 1 < array.length && array[indice] > array[indice + 1]) {
            indice++;
        }

        return indice == array.length - 1;
    }

    public static int encontrarPico(int[] array) {
        int inicio = 0, fin = array.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] < array[medio + 1]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }

        return inicio;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 4, 2 };

        boolean resultado = esMontaña(array);
        System.out.println("El array es una montaña: " + resultado);

        if (resultado) {
            int pico = encontrarPico(array);
            System.out.println("El punto más alto está en el índice: " + pico);
        }
    }
}