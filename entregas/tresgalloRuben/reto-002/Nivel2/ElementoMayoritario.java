package Nivel2;

public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] numeros) {
        int n = numeros.length;
        int medio = n / 2;
        int candidato = numeros[medio];
        
        int cuenta = 0;
        for (int num : numeros) {
            if (num == candidato) {
                cuenta++;
            }
        }
        
        if (cuenta > n / 2) {
            return candidato;
        } else {
            return -1; 
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        int mayoritario = encontrarElementoMayoritario(numeros);
        System.out.println("Elemento mayoritario: " + mayoritario);
    }
}
