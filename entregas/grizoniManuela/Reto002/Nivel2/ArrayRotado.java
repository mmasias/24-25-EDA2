package Reto002.Nivel2;

public class ArrayRotado {

    public static int encontrarPuntoRotacion(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        if (arr[low] <= arr[high]) {
            return 0;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return 0; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        int puntoRotacion = encontrarPuntoRotacion(arr);
        System.out.println("Salida: " + puntoRotacion);
    }
}

