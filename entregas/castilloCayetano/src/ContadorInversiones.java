public class ContadorInversiones {
    // Completado
    public static void main(String[] args) {
        imprimirContadorInversiones();
    }

    public void mostrar() {
        imprimirContadorInversiones();
    }

    public static void imprimirContadorInversiones() {
        int[] array = { 2, 4, 1, 3, 5 };
        int count = contarInversiones(array);
        System.out.println("Número de pares en orden incorrecto: " + count);
    }

    public static int contarInversiones(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeSortYContar(array, 0, array.length - 1);
    }

    private static int mergeSortYContar(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return 0;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        int conteo = 0;
        conteo += mergeSortYContar(array, izquierda, medio);
        conteo += mergeSortYContar(array, medio + 1, derecha);
        conteo += mergeYContar(array, izquierda, medio, derecha);
        return conteo;
    }

    private static int mergeYContar(int[] array, int izquierda, int medio, int derecha) {
        int[] arrayIzquierda = new int[medio - izquierda + 1];
        int[] arrayDerecha = new int[derecha - medio];

        for (int i = 0; i < arrayIzquierda.length; i++) {
            arrayIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < arrayDerecha.length; i++) {
            arrayDerecha[i] = array[medio + 1 + i];
        }

        int i = 0, j = 0, k = izquierda, intercambios = 0;

        while (i < arrayIzquierda.length && j < arrayDerecha.length) {
            if (arrayIzquierda[i] <= arrayDerecha[j]) {
                array[k++] = arrayIzquierda[i++];
            } else {
                array[k++] = arrayDerecha[j++];
                intercambios += (medio + 1) - (izquierda + i);
            }
        }

        while (i < arrayIzquierda.length) {
            array[k++] = arrayIzquierda[i++];
        }

        while (j < arrayDerecha.length) {
            array[k++] = arrayDerecha[j++];
        }

        return intercambios;
    }
}