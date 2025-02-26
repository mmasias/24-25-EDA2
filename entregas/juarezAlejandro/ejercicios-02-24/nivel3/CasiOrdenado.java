package nivel3;

public class CasiOrdenado {
    public static void main(String[] args) {
        int[] entrada = { 2, 1, 3, 5, 4 };
        int k = 2;
        int[] ordenados = ordenarCasiOrdenado(entrada, k);
        for (int num : ordenados) {
            System.out.print(num + " ");
        }
    }

    public static int[] ordenarCasiOrdenado(int[] array, int k) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}