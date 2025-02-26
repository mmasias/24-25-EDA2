package nivel2;

public class PicoMontaña {
    public static void main(String[] args) {
        int[] entrada = { 1, 3, 5, 7, 6, 4, 2 };
        int pico = encontrarPico(entrada);
        System.out.println("El número en la posición del pico es: " + entrada[pico]);
        System.out.println("El índice del pico de la montaña es: " + pico);
    }

    public static int encontrarPico(int[] entrada) {
        int inicio = 0;
        int fin = entrada.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (entrada[medio] < entrada[medio + 1]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;

    }

}
