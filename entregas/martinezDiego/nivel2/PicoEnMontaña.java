package entregas.martinezDiego.nivel2;

public class PicoEnMontaña {
    public static int encontrarPico(int[] numeros) {
        int inicio = 0;
        int fin = numeros.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (medio > 0 && medio < numeros.length - 1) {
                if (numeros[medio] > numeros[medio - 1] && numeros[medio] > numeros[medio + 1]) {
                    return numeros[medio];
                } else if (numeros[medio] < numeros[medio - 1]) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            } else if (medio == 0 || medio == numeros.length - 1) {
                return numeros[medio];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 6, 4, 2};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarPico(numeros);
        System.out.println("Salida: " + resultado);
    }
}

