public class ContadorInversiones {

    private static int contarInversionesDirectas(int[] arr) {
        int contador = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    contador++;
                    System.out.println("Inversión: (" + arr[i] + "," + arr[j] + ")");
                }
            }
        }

        return contador;
    }

    private static int contarInversionesMergeSort(int[] arr) {
        return contarInversionesRecursivo(arr, 0, arr.length - 1);
    }

    private static int contarInversionesRecursivo(int[] arr, int inicio, int fin) {
        int contador = 0;

        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            contador += contarInversionesRecursivo(arr, inicio, medio);
            contador += contarInversionesRecursivo(arr, medio + 1, fin);

            contador += contarInversionesFusion(arr, inicio, medio, fin);
        }

        return contador;
    }

    private static int contarInversionesFusion(int[] arr, int inicio, int medio, int fin) {
        int[] izquierda = new int[medio - inicio + 1];
        int[] derecha = new int[fin - medio];

        for (int i = 0; i < izquierda.length; i++) {
            izquierda[i] = arr[inicio + i];
        }

        for (int i = 0; i < derecha.length; i++) {
            derecha[i] = arr[medio + 1 + i];
        }

        int i = 0, j = 0, k = inicio;
        int inversiones = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
                inversiones += (izquierda.length - i);
            }
            k++;
        }

        while (i < izquierda.length) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < derecha.length) {
            arr[k] = derecha[j];
            j++;
            k++;
        }

        return inversiones;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };

        System.out.println("Método directo:");
        int inversiones = contarInversionesDirectas(arr);
        System.out.println("Número total de inversiones: " + inversiones);

        arr = new int[] { 2, 4, 1, 3, 5 };

        System.out.println("\nMétodo Merge Sort:");
        inversiones = contarInversionesMergeSort(arr);
        System.out.println("Número total de inversiones: " + inversiones);
    }
}