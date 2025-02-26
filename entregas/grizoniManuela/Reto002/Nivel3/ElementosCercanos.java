package Reto002.Nivel3;

public class ElementosCercanos {

    public static int[] encontrarKMasCercanos(int[] arr, int k, double target) {
        int n = arr.length;
        int low = 0, high = n - k; 
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target - arr[mid] > arr[mid + k] - target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = arr[low + i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] res = encontrarKMasCercanos(arr, k, target);
        
        System.out.print("Salida: [");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i < res.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
