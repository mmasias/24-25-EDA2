package entregas.martinezDiego.nivel2;

public class ElementoUnico {
    public static int encontrarElementoUnico(int[] numeros) {
        int unico = 0;

        for (int numero : numeros) {
            unico ^= numero;
        }

        return unico;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarElementoUnico(numeros);
        System.out.println("Salida: " + resultado);
    }
}

