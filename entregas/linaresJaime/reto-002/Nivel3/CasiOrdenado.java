public class CasiOrdenado {

    public static void ordenarCasiOrdenado(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int limite = Math.min(i + k, n - 1);
            for (int j = i + 1; j <= limite; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] entrada = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarCasiOrdenado(entrada, k);
        for (int num : entrada) {
            System.out.print(num + " ");
        }
    }
}
