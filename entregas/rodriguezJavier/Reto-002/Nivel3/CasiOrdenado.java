public class CasiOrdenado {
    public static void ordenarCasiOrdenado(int[] numeros, int k) {
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j <= Math.min(i + k, numeros.length - 1); j++) {
                if (numeros[i] > numeros[j]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarCasiOrdenado(numeros, k);
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}