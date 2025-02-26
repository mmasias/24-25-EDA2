package Nivel1;

public class Montaña {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 3, 5, 4, 2 },
                { 1, 2, 3, 4, 5 },
                { 5, 4, 3, 2, 1 },
                { 1, 2, 2, 3, 1 },
                { 2, 1 }
        };

        for (int i = 0; i < matriz.length; i++) {
            boolean resultado = esMontaña(matriz[i]);
            System.out.println("Fila " + (i + 1) + ": " + resultado);
        }
    }

    public static boolean esMontaña(int[] arr) {
        if (arr.length < 3)
            return false;

        int i = 0;
        int n = arr.length;

        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1)
            return false;

        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
