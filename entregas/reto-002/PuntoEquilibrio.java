public class PuntoEquilibrio {

    public static int encontrarPuntoEquilibrio(int[] arr) {
        int n = arr.length;

        int sumaTotal = 0;
        for (int i = 0; i < n; i++) {
            sumaTotal += arr[i];
        }

        int sumaIzquierda = 0;

        for (int i = 0; i < n; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - arr[i];

            if (sumaIzquierda == sumaDerecha) {
                return i;
            }

            sumaIzquierda += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6 };
        int indice = encontrarPuntoEquilibrio(arr);
        if (indice != -1) {
            System.out.println("Punto de equilibrio en el índice: " + indice);
        } else {
            System.out.println("No existe punto de equilibrio");
        }
    }
}