public class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        int totalElementos = 0;
        for (int[] arr : arrays) {
            totalElementos += arr.length;
        }
        int[] resultado = new int[totalElementos];
        int[] indices = new int[arrays.length];
        int k = 0;
        while (k < totalElementos) {
            int minValor = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arrays.length; i++) {
                if (indices[i] < arrays[i].length && arrays[i][indices[i]] < minValor) {
                    minValor = arrays[i][indices[i]];
                    minIndex = i;
                }
            }
            resultado[k++] = minValor;
            indices[minIndex]++;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] resultado = combinarArrays(arrays);
        for (int numero : resultado) {
            System.out.print(numero + " ");
        }
    }
}

