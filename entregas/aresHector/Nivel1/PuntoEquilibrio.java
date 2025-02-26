public class PuntoEquilibrio {
    public static int puntoEquilibrio(int[] arr) {
        int sumaTotal = 0, sumaIzquierda = 0;

        for (int num : arr) {
            sumaTotal += num;
        }

        for (int i = 0; i < arr.length; i++) {
            if (sumaIzquierda == (sumaTotal - sumaIzquierda - arr[i])) {
                return i;
            }
            sumaIzquierda += arr[i];
        }

        return -1; // Si no hay punto de equilibrio
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println(puntoEquilibrio(arr)); // Output: 3
    }
}
