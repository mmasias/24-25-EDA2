package entregas.lopezMartin.ejerciciosAlgoritmos;

public class KElementosCercanos {

    public static int[] encontrarKCercanos(int[] arr, int k, double target) {
        int n = arr.length;
        int[] resultado = new int[k];
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                double diff1 = arr[j] - target;
                if (diff1 < 0) diff1 = -diff1;
                
                double diff2 = arr[j + 1] - target;
                if (diff2 < 0) diff2 = -diff2;
                
                if (diff1 > diff2) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        for (int i = 0; i < k; i++) {
            resultado[i] = arr[i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] resultado = encontrarKCercanos(arr, k, target);
        System.out.print("K números más cercanos: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
