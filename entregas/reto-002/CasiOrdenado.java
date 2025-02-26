public class CasiOrdenado {

    public static void ordenarCasiOrdenado(int[] arr, int k) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;

            while (j >= Math.max(0, i - k) && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 5, 4 };
        int k = 2;

        System.out.println("Array original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        ordenarCasiOrdenado(arr, k);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}