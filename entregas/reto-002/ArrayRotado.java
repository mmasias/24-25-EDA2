public class ArrayRotado {

    public static int encontrarPuntoRotacion(int[] arr) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        if (arr[izquierda] < arr[derecha]) {
            return 0;
        }

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (medio < arr.length - 1 && arr[medio] > arr[medio + 1]) {
                return medio + 1;
            }

            if (medio > 0 && arr[medio - 1] > arr[medio]) {
                return medio;
            }

            if (arr[izquierda] <= arr[medio]) {

                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3 };
        int puntoRotacion = encontrarPuntoRotacion(arr);
        System.out.println("El punto de rotación está en el índice: " + puntoRotacion);
    }
}