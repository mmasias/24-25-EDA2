package Nivel2;

public class NúmeroRepetido {

    public static void main(String[] args) {
        int[] numeros = { 1, 1, 1, 1, 2, 2, 3 };
        int mayoritario = encontrarMayoritario(numeros);
        System.out.println(mayoritario);
    }

    public static int encontrarMayoritario(int[] numeros) {
        int n = numeros.length;
        int mayoritario = 0;
        int contador = 0;

        for (int i = 0; i < n; i++) {
            if (contador == 0) {
                mayoritario = numeros[i];
                contador = 1;
            } else if (mayoritario == numeros[i]) {
                contador++;
            } else {
                contador--;
            }
        }

        return mayoritario;
    }

}
