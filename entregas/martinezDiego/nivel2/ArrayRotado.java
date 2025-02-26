package entregas.martinezDiego.nivel2;

public class ArrayRotado {
    public static int encontrarPuntoDeRotacion(int[] numeros) {
        int inicio = 0;
        int fin = numeros.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (numeros[medio] > numeros[medio + 1]) {
                return medio + 1;
            } else if (numeros[medio] < numeros[inicio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] numeros = { 3, 4, 1, 2 };

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarPuntoDeRotacion(numeros);
        System.out.println("Salida: " + resultado);
    }
}
