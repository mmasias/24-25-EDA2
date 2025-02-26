public class ParesDiferencia {
    // Completado
    public static void main(String[] args) {
        imprimirParesDiferencia();
    }

    public void mostrar() {
        imprimirParesDiferencia();
    }

    public static void imprimirParesDiferencia() {
        int[] array = { 1, 7, 5, 9, 2, 12, 3 };
        int[] ks = { 2 };
        for (int k : ks) {
            System.out.println("Pares con diferencia " + k + ":");
            int[][] resultado = encontrarParesDiferencia(array, k);
            System.out.print("[");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print("[" + resultado[i][0] + "," + resultado[i][1] + "]");
                if (i < resultado.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static int[][] encontrarParesDiferencia(int[] array, int k) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) == k) {
                    contador++;
                }
            }
        }

        int[][] resultado = new int[contador][2];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) == k) {
                    resultado[index][0] = array[i];
                    resultado[index][1] = array[j];
                    index++;
                }
            }
        }
        return resultado;
    }
}