public class CombinacionArraysSecuencial {
    public static void main(String[] args) {
        int[][] arrays = { { 1, 4, 7 }, { 2, 7, 8 }, { 3, 6, 9 } };
        int[] resultado = combinarArraysSecuencial(arrays);

        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    public static int[] combinarArraysSecuencial(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        int longitud = 0;
        for (int[] array : arrays) {
            longitud += array.length;
        }

        int[] resultado = new int[0];

        for (int[] array : arrays) {
            resultado = combinarDosArrays(resultado, array);
        }

        return resultado;
    }

    private static int[] combinarDosArrays(int[] array1, int[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int[] resultado = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                resultado[k++] = array1[i++];
            } else {
                resultado[k++] = array2[j++];
            }
        }

        while (i < n1) {
            resultado[k++] = array1[i++];
        }

        while (j < n2) {
            resultado[k++] = array2[j++];
        }

        return resultado;
    }
}