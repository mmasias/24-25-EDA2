public class PicoMontana {
    public static int encontrarPico(int[] arr) {
        int izquierda = 0, derecha = arr.length - 1;

        while (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arr[medio] < arr[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }

        return arr[izquierda];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        System.out.println(encontrarPico(arr));
    }
}
