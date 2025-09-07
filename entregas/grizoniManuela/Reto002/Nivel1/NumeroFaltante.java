package Reto002.Nivel1;

public class NumeroFaltante {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1; 
        int sumaEsperada = (n * (n + 1)) / 2; 
        int sumaReal = 0;

        for (int num : numeros) {
            sumaReal += num;
        }

        return sumaEsperada - sumaReal;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        int resultado = encontrarNumeroFaltante(numeros);
        System.out.println("Número faltante: " + resultado);
    }
}

