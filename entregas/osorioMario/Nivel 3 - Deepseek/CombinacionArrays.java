public class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) return new int[0];
        return combinar(arrays, 0, arrays.length - 1);
    }

    private static int[] combinar(int[][] arrays, int inicio, int fin) {
        if (inicio == fin) return arrays[inicio];
        int medio = inicio + (fin - inicio) / 2;
        int[] izquierda = combinar(arrays, inicio, medio);
        int[] derecha = combinar(arrays, medio + 1, fin);
        return fusionar(izquierda, derecha);
    }

    private static int[] fusionar(int[] a, int[] b) {
        int[] resultado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultado[k++] = a[i++];
            } else {
                resultado[k++] = b[j++];
            }
        }
        while (i < a.length) resultado[k++] = a[i++];
        while (j < b.length) resultado[k++] = b[j++];
        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] resultado = combinarArrays(arrays);
        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}