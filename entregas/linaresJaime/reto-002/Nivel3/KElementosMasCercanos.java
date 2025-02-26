public class KElementosMasCercanos {

    public static int[] kMasCercanos(int[] arr, int k, double target) {
        int n = arr.length;
        int[] indices = new int[k];
        double[] distancias = new double[k];
        for (int i = 0; i < k; i++) {
            indices[i] = -1;
            distancias[i] = Double.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            double distancia = Math.abs(arr[i] - target);
            int maxIndex = 0;
            for (int j = 1; j < k; j++) {
                if (distancias[j] > distancias[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (distancia < distancias[maxIndex]) {
                distancias[maxIndex] = distancia;
                indices[maxIndex] = i;
            }
        }

        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = arr[indices[i]];
        }
        ordenarResultado(resultado);
        return resultado;
    }

    private static void ordenarResultado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] entrada = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] resultado = kMasCercanos(entrada, k, target);

        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
