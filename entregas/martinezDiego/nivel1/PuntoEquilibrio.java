package entregas.martinezDiego.nivel1;

public class PuntoEquilibrio {
    public static int encontrarPuntoDeEquilibrio(int[] numeros) {
        int sumaIzquierda = 0;
        int sumaDerecha = 0;

        for (int i = 0; i < numeros.length; i++) {
            sumaDerecha += numeros[i];
        }

        for (int i = 0; i < numeros.length; i++) {
            sumaDerecha -= numeros[i];

            if (sumaIzquierda == sumaDerecha) {
                return i;
            }

            sumaIzquierda += numeros[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 6};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarPuntoDeEquilibrio(numeros);
        System.out.println("Salida: " + resultado);
    }
}

