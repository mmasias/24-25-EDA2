package Reto002.Nivel2;

public class ProductoDefectuoso {

    public static int encontrarPrimerDefectuoso(boolean[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid]) { 
                if (mid == 0 || !arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else { 
                low = mid + 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        boolean[] arr = {false, false, false, true, true};
        int primerDefectuoso = encontrarPrimerDefectuoso(arr);
        System.out.println("Salida: " + primerDefectuoso);
    }
}
