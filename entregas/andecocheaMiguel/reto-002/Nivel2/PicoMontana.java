public class PicoMontana {
    public static int encontrarPico(int[] numeros) {
        int inicio = 0, fin = numeros.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (numeros[medio] < numeros[medio + 1]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return numeros[inicio];
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 6, 4, 2};
        System.out.println("Pico de la montaña: " + encontrarPico(numeros));
    }
}