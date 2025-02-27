package entregas.lopezMartin.reto002.src;

public class ParesConDiferencia {
    
    public static void encontrarPares(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] - arr[j] == k || arr[j] - arr[i] == k) { 
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        encontrarPares(arr, k);
    }
}
