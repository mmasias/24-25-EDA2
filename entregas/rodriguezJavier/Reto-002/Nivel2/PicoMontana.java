public class PicoMontana {
    public static int encontrarPico(int[] numeros) {
        int izquierda = 0, derecha = numeros.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (numeros[medio] < numeros[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        return numeros[izquierda];
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 6, 4, 2};
        System.out.println(encontrarPico(numeros));
    }
}