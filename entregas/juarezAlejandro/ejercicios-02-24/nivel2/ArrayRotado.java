package nivel2;

public class ArrayRotado {
    public static void main(String[] args) {
        int[] entrada = { 4, 5, 6, 1, 2, 3 };
        int puntoRotacion = encontrarPuntoRotacion(entrada);
        System.out.println("El punto de rotación está en el índice: " + puntoRotacion);
    }

    public static int encontrarPuntoRotacion(int[] entrada) {
        int inicio = 0;
        int fin = entrada.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (entrada[medio] > entrada[fin]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }

        return inicio;
    }
}
