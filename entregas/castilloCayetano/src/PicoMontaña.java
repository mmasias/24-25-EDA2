public class PicoMontaña {
    // Completado
    public static void main(String[] args) {
        imprimirPicoMontaña();
    }

    public void mostrar() {
        imprimirPicoMontaña();
    }

    public static void imprimirPicoMontaña() {
        int[] montaña = { 1, 2, 3, 4, 8, 4, 3, 2, 1 };
        int indicePico = encontrarPicoMontaña(montaña);
        int pico = montaña[indicePico];
        System.out.println("Pico de la montaña: " + pico);
    }

    public static int encontrarPicoMontaña(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] > array[medio + 1]) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }
        return inicio;
    }
}
