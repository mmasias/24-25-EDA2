package Reto002.Nivel4;

public class ParesConDiferencia {
    public static int[][] paresConDiferencia(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[j] > arr[i] && arr[j] - arr[i] == k) {
                    count++;
                }
            }
        }
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[j] > arr[i] && arr[j] - arr[i] == k) {
                    result[index][0] = arr[i];
                    result[index][1] = arr[j];
                    index++;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        int[][] pairs = paresConDiferencia(arr, k);
        System.out.print("Salida: [");
        for (int i = 0; i < pairs.length; i++) {
            System.out.print("[" + pairs[i][0] + "," + pairs[i][1] + "]");
            if (i < pairs.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}


