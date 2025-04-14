package entregas.PinedaOscar.Reto_002.Nivel4;

public class ParesConDiferencia {
    public static void encontrarPares(int[] array, int k) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] - array[i] == k) {
                    System.out.println("[" + array[i] + ", " + array[j] + "]");
                } else if (array[j] - array[i] > k) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 7, 5, 9, 2, 12, 3 };
        int k = 2;
        System.out.println("Pares con diferencia " + k + ":");
        encontrarPares(array, k);
    }
}