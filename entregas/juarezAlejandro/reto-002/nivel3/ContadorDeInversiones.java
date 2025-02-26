package nivel3;

public class ContadorDeInversiones {
    public static void main(String[] args) {
        int[] entrada = { 2, 4, 1, 3, 5 };
        int inversiones = contarInversiones(entrada);
        System.out.println("En total hay " + inversiones + " inversiones");
    }

    public static int contarInversiones(int[] array) {
        int n = array.length;
        int inversiones = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    inversiones++;
                    System.out.println("Inversión: (" + array[i] + ", " + array[j] + ")");
                }
            }
        }

        return inversiones;
    }
}