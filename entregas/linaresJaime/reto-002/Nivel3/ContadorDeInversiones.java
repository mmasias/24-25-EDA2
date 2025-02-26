public class ContadorDeInversiones {

    public static int contarInversiones(int[] arr) {
        return mergeSortContar(arr, 0, arr.length - 1);
    }

    private static int mergeSortContar(int[] arr, int izquierda, int derecha) {
        int conteo = 0;
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            conteo += mergeSortContar(arr, izquierda, medio);
            conteo += mergeSortContar(arr, medio + 1, derecha);
            conteo += merge(arr, izquierda, medio, derecha);
        }
        return conteo;
    }

    private static int merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
        int[] izquierdaArr = new int[n1];
        int[] derechaArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            izquierdaArr[i] = arr[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            derechaArr[j] = arr[medio + 1 + j];
        }

        int i = 0, j = 0, k = izquierda, inversiones = 0;
        while (i < n1 && j < n2) {
            if (izquierdaArr[i] <= derechaArr[j]) {
                arr[k++] = izquierdaArr[i++];
            } else {
                arr[k++] = derechaArr[j++];
                inversiones += (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = izquierdaArr[i++];
        }
        while (j < n2) {
            arr[k++] = derechaArr[j++];
        }
        return inversiones;
    }

    public static void main(String[] args) {
        int[] entrada = {2, 4, 1, 3, 5};
        int resultado = contarInversiones(entrada);
        System.out.println(resultado);
    }
}
