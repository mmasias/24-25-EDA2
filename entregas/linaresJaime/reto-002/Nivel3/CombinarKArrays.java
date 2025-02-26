public class CombinarKArrays {

    public static int[] combinarKArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        while (arrays.length > 1) {
            int nuevaLongitud = (arrays.length + 1) / 2;
            int[][] nuevoArrays = new int[nuevaLongitud][];

            for (int i = 0; i < arrays.length / 2; i++) {
                nuevoArrays[i] = combinarDosArrays(arrays[2 * i], arrays[2 * i + 1]);
            }

            if (arrays.length % 2 == 1) {
                nuevoArrays[nuevaLongitud - 1] = arrays[arrays.length - 1];
            }

            arrays = nuevoArrays;
        }

        return arrays[0];
    }

    private static int[] combinarDosArrays(int[] arr1, int[] arr2) {
        int[] combinado = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combinado[k++] = arr1[i++];
            } else {
                combinado[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combinado[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            combinado[k++] = arr2[j++];
        }

        return combinado;
    }

    public static void main(String[] args) {
        int[][] entrada = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] resultado = combinarKArrays(entrada);

        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
