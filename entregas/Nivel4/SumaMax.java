package Nivel4;

public class SumaMax {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        encontrarSumaMaximaBruto(arr);
    }

    public static void encontrarSumaMaximaBruto(int[] arr) {
        int n = arr.length;
        int maxSuma = Integer.MIN_VALUE;
        int inicio = 0, fin = 0;

        for (int i = 0; i < n; i++) {
            int suma = 0;
            for (int j = i; j < n; j++) {
                suma += arr[j];
                if (suma > maxSuma) {
                    maxSuma = suma;
                    inicio = i;
                    fin = j;
                }
            }
        }

        System.out.print("[");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(arr[i] + (i < fin ? ", " : ""));
        }
        System.out.println("]");
    }
}
