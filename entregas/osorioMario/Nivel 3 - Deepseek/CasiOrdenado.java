public class CasiOrdenado {
    public static void ordenar(int[] numeros, int k) {
        for (int i = 1; i < numeros.length; i++) {
            int temp = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > temp) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {2, 1, 3, 5, 4};
        int k = 2;
        ordenar(numeros, k);
        System.out.print("Array ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}