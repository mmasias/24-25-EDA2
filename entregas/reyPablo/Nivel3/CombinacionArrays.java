public class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) return new int[0];
        return combinar(arrays, 0, arrays.length - 1);
    }

    private static int[] combinar(int[][] arrays, int inicio, int fin) {
        if (inicio == fin) return arrays[inicio];
        int medio = (inicio + fin) / 2;
        int[] izquierda = combinar(arrays, inicio, medio);
        int[] derecha = combinar(arrays, medio + 1, fin);
        return fusionar(izquierda, derecha);
    }

    private static int[] fusionar(int[] arr1, int[] arr2) {
        int[] resultado = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                resultado[k++] = arr1[i++];
            } else {
                resultado[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) resultado[k++] = arr1[i++];
        while (j < arr2.length) resultado[k++] = arr2[j++];
        return resultado;
    }

    public static void main(String[] args) {
        int[][] entrada = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] salida = combinarArrays(entrada);
        for (int num : salida) System.out.print(num + " ");
    }
}