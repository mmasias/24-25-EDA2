package entregas.lopezMartin.reto002.src;

public class CasiOrdenado {

    public static void ordenarArray1(int[] arr, int k) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int inicio = (i - k < 0) ? 0 : (i - k);
            int fin = (i + k >= n - 1) ? (n - 1) : (i + k);
            
            for (int j = inicio; j < fin; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenarArray2(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j] && j - 1 >= i - k) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--; 
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarArray1(arr, k);
        System.out.print("Array ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
