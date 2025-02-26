package Nivel3;

public class CombinarArrays {
    public static void main(String[] args) {
        int[][] arrays = {
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 3, 6, 9 }
        };

        int[] resultado = combinarKArrays(arrays);

        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    public static int[] combinarKArrays(int[][] arrays) {
        int k = arrays.length;
        int totalElementos = 0;

        for (int i = 0; i < k; i++) {
            totalElementos += arrays[i].length;
        }

        int[] resultado = new int[totalElementos];
        int[] indices = new int[k];
        for (int i = 0; i < totalElementos; i++) {
            int minIndex = -1;
            int minValor = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (indices[j] < arrays[j].length && arrays[j][indices[j]] < minValor) {
                    minValor = arrays[j][indices[j]];
                    minIndex = j;
                }
            }

            resultado[i] = minValor;
            indices[minIndex]++;
        }

        return resultado;
    }
}
