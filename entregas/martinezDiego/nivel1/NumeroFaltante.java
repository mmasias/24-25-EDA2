package entregas.martinezDiego.nivel1;

public class NumeroFaltante {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1;
        int sumaEsperada = n * (n + 1) / 2;
        int sumaReal = 0;

        for (int numero : numeros) {
            sumaReal += numero;
        }

        return sumaEsperada - sumaReal;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 5, 6};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarNumeroFaltante(numeros);
        System.out.println("Salida: " + resultado);
    }
}

