package Nivel1;

public class SumaObjeto {
    public static void main(String[] args) {
        int[][] matriz = {
                { 3, 2, 9, 8, 5, 1 },
                { 4, 6, 7, 2, 9, 3 },
                { 8, 1, 4, 5, 7, 6 },
                { 2, 9, 3, 6, 1, 8 },
                { 5, 7, 8, 2, 4, 9 },
                { 1, 3, 6, 9, 2, 7 }
        };

        int objetivo = 10;

        for (int i = 0; i < matriz.length; i++) {
            int[] resultado = encontrarSuma(matriz[i], objetivo);
            if (resultado[0] != -1) {
                System.out.println("Fila " + (i + 1) + ": [" + resultado[0] + ", " + resultado[1] + "]");
            } else {
                System.out.println("Fila " + (i + 1) + ": No se encontró pareja.");
            }
        }
    }

    public static int[] encontrarSuma(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
