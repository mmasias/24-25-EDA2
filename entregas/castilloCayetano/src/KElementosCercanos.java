public class KElementosCercanos {
    // Completado
    public static void main(String[] args) {
        imprimirElementosCercanos();
    }

    public void mostrar() {
        imprimirElementosCercanos();
    }

    public static void imprimirElementosCercanos() {
        int[] array = { 1, 2, 3, 4, 5 };
        int k = 2;
        double target = 3.7;
        int[] elementosCercanos = encontrarElementosCercanos(array, k, target);
        ordenarElementos(elementosCercanos);
        System.out.print("[");
        for (int i = 0; i < elementosCercanos.length; i++) {
            System.out.print(elementosCercanos[i]);
            if (i < elementosCercanos.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static int[] encontrarElementosCercanos(int[] array, int k, double target) {
        int[] elementosCercanos = new int[k];
        for (int i = 0; i < k; i++) {
            double menorDiferencia = Double.MAX_VALUE;
            int indiceMenor = -1;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != Integer.MAX_VALUE && Math.abs(array[j] - target) < menorDiferencia) {
                    menorDiferencia = Math.abs(array[j] - target);
                    indiceMenor = j;
                }
            }
            elementosCercanos[i] = array[indiceMenor];
            array[indiceMenor] = Integer.MAX_VALUE;
        }
        return elementosCercanos;
    }

    public static void ordenarElementos(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}