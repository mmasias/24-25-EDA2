public class KElementosCercanos {
    public static int[] encontrarKElementosCercanos(int[] numeros, int k, int target) {
        int[] resultado = new int[k];
        int[] diferencias = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            diferencias[i] = Math.abs(numeros[i] - target);
        }
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 1; j < numeros.length; j++) {
                if (diferencias[j] < diferencias[minIndex]) {
                    minIndex = j;
                }
            }
            resultado[i] = numeros[minIndex];
            diferencias[minIndex] = Integer.MAX_VALUE;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        int target = 3;
        int[] resultado = encontrarKElementosCercanos(numeros, k, target);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}