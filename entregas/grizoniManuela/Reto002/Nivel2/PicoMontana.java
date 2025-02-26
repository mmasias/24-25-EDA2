package Reto002.Nivel2;

public class PicoMontana{

    public static int encontrarPico(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else { 
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        System.out.println("Salida: " + encontrarPico(arr));
    }
}
