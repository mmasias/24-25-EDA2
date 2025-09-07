package Reto002.Nivel2;

public class ElementoUnico {

    public static int encontrarElementoUnico(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--; 
            }
            if (arr[mid] == arr[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println("Salida: " + encontrarElementoUnico(arr));
    }
}
