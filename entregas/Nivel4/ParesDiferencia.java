package Nivel4;

public class ParesDiferencia {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 5, 9, 2, 12, 3 };
        int k = 2;
        encontrarParesBruto(arr, k);
    }

    public static void encontrarParesBruto(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }
    }
}
