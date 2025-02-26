public class PicoMontana {
    public static int encontrar(int[] arr) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;
            if (arr[mid] < arr[mid + 1]) {
                inicio = mid + 1;
            } else {
                fin = mid;
            }
        }
        return arr[inicio];
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        System.out.println(encontrar(arr));
    }
}