package EjerciciosAlgoritmos;

public class CombinacionArrays {

    public static int[] combinarArrays(int[][] arrays) {
        int totalElementos = 0;
        for (int indice = 0; indice < arrays.length; indice++) {
            totalElementos += arrays[indice].length;
        }

        int[] resultado = new int[totalElementos];
        int[] indices = new int[arrays.length];
        int indiceResultado = 0;

        while (indiceResultado < totalElementos) {
            int minValor = Integer.MAX_VALUE;
            int minIndice = -1;

            for (int indice = 0; indice < arrays.length; indice++) {
                if (indices[indice] < arrays[indice].length && arrays[indice][indices[indice]] < minValor) {
                    minValor = arrays[indice][indices[indice]];
                    minIndice = indice;
                }
            }

            resultado[indiceResultado++] = minValor;
            indices[minIndice]++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] resultado = combinarArrays(arrays);
        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
