package Nivel3;

public class CasiOrdenado {
    public static void main(String[] args) {
        int[] numeros = { 2, 1, 3, 5, 4 };
        int k = 2;

        ordenarCasiOrdenado(numeros, k);

        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }

    public static void ordenarCasiOrdenado(int[] numeros, int k) {
        int n = numeros.length;

        for (int i = 1; i < n; i++) {
            int valor = numeros[i];
            int j = i;

            while (j > 0 && j > i - k - 1 && numeros[j - 1] > valor) {
                numeros[j] = numeros[j - 1];
                j--;
            }
            numeros[j] = valor;
        }
    }
}
