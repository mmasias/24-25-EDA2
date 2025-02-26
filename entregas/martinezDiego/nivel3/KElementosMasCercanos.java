package entregas.martinezDiego.nivel3;

public class KElementosMasCercanos {
    public static int[] kElementosMasCercanos(int[] numeros, int k, double objetivo) {
        int[] resultado = new int[k];
        int numero = numeros.length;

        int[] diferencias = new int[numero];
        for (int i = 0; i < numero; i++) {
            diferencias[i] = (int) Math.abs(numeros[i] - objetivo);
        }

        for (int i = 0; i < k; i++) {
            int indiceMinimo = obtenerIndiceMinimo(diferencias);
            resultado[i] = numeros[indiceMinimo];
            diferencias[indiceMinimo] = Integer.MAX_VALUE; 
        }

        return resultado;
    }

    public static int obtenerIndiceMinimo(int[] diferencias) {
        int minIndice = 0;
        for (int i = 1; i < diferencias.length; i++) {
            if (diferencias[i] < diferencias[minIndice]) {
                minIndice = i;
            }
        }
        return minIndice;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        double objetivo = 3.7;

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], k = " + k + ", objetivo = " + objetivo);

        int[] resultado = kElementosMasCercanos(numeros, k, objetivo);
        System.out.print("Salida: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

