public class PuntoDeRotacion {
    public static int encontrar(int[] arr) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;
            if (arr[mid] > arr[fin]) {
                inicio = mid + 1;
            } else {
                fin = mid;
            }
        }
        return inicio;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println(encontrar(arr));
    }
}