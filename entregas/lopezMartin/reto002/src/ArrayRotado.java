package entregas.lopezMartin.reto002.src;

public class ArrayRotado {

    public static int encontrarPuntoRotacion1(int[] arr) {
        int inicio = 0;
        int fin = arr.length - 1;
        
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] > arr[fin]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }

    public static int encontrarPuntoRotacion2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        int resultado = encontrarPuntoRotacion1(arr);
        System.out.println("Punto de rotación en la posición: " + resultado);
    }
}
