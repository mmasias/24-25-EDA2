package Nivel3;

public class ContadorInversiones {
    public static void main(String[] args) {
        int[] numeros = { 2, 4, 1, 3, 5 };
        int inversiones = contarInversionesBruto(numeros);
        System.out.println(inversiones);
    }

    public static int contarInversionesBruto(int[] numeros) {
        int contador = 0;
        int n = numeros.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numeros[i] > numeros[j]) {
                    contador++;
                }
            }
        }

        return contador;
    }
}
