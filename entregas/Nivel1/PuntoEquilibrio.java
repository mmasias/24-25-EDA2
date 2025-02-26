package Nivel1;

public class PuntoEquilibrio {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int punto = encontrarPuntoEquilibrio(numeros);
        System.out.println(punto);
    }

    public static int encontrarPuntoEquilibrio(int[] numeros) {
        int n = numeros.length;
        int[] sumaIzquierda = new int[n];
        int[] sumaDerecha = new int[n];

        sumaIzquierda[0] = numeros[0];
        for (int i = 1; i < n; i++) {
            sumaIzquierda[i] = sumaIzquierda[i - 1] + numeros[i];
        }

        sumaDerecha[n - 1] = numeros[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sumaDerecha[i] = sumaDerecha[i + 1] + numeros[i];
        }

        for (int i = 0; i < n; i++) {
            if (sumaIzquierda[i] == sumaDerecha[i]) {
                return i;
            }
        }

        return -1;
    }
}