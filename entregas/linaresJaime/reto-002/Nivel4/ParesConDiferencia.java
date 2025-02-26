public class ParesConDiferencia {
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        System.out.println("Pares con diferencia " + k + ":");
        encontrarParesConDiferencia(arr, k);
        
        int[] ks = {1, 2, 3};
        System.out.println("Pares para múltiples k:");
        encontrarParesMultiplesK(arr, ks);
    }

    public static void encontrarParesConDiferencia(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }
    }

    public static void encontrarParesMultiplesK(int[] arr, int[] ks) {
        for (int k : ks) {
            System.out.println("Diferencia " + k + ":");
            encontrarParesConDiferencia(arr, k);
        }
    }
}
