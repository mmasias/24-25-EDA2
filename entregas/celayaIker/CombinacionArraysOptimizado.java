package entregas.celayaIker;

public class CombinacionArraysOptimizado {
    public static int[] combinarArrays(int[][] arrays) {
        if (arrays.length == 0) return new int[]{};

        return fusionarPorNiveles(arrays, 0, arrays.length - 1);
    }

    private static int[] fusionarPorNiveles(int[][] arrays, int inicio, int fin) {
        if (inicio == fin) return arrays[inicio]; 

        int medio = inicio + (fin - inicio) / 2;

        int[] izquierda = fusionarPorNiveles(arrays, inicio, medio);
        int[] derecha = fusionarPorNiveles(arrays, medio + 1, fin);

        return merge(izquierda, derecha);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] resultado = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                resultado[k++] = arr1[i++];
            } else {
                resultado[k++] = arr2[j++];
            }
        }

        while (i < n1) resultado[k++] = arr1[i++];
        while (j < n2) resultado[k++] = arr2[j++];

        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {0, 10, 12}, {11, 13, 14}};
        int[] resultado = combinarArrays(arrays);

        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
