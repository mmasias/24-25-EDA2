public class KElementosCercanos {
    public static int[] encontrarCercanos(int[] numeros, int k, double target) {
        int izquierda = 0;
        int derecha = numeros.length - k;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (target - numeros[medio] > numeros[medio + k] - target) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        int[] resultado = new int[k];
        System.arraycopy(numeros, izquierda, resultado, 0, k);
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] cercanos = encontrarCercanos(numeros, k, target);
        System.out.print("Elementos más cercanos: ");
        for (int num : cercanos) {
            System.out.print(num + " ");
        }
    }
}