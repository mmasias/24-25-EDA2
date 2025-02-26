public class PicoMontana {

    public static int encontrarPico(int[] arr) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arr[medio] < arr[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }

        return arr[izquierda];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 6, 4, 2 };
        int pico = encontrarPico(arr);
        System.out.println("El valor del pico es: " + pico);
    }
}