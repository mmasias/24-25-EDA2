public class ElementoMayoritario {

    public static int encontrarMayoritarioConteo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] conteo = new int[max + 1];

        for (int num : array) {
            conteo[num]++;
            if (conteo[num] > array.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public static int encontrarMayoritarioBoyerMoore(int[] array) {
        int candidato = 0;
        int contador = 0;

        for (int num : array) {
            if (contador == 0) {
                candidato = num;
                contador = 1;
            } else if (candidato == num) {
                contador++;
            } else {
                contador--;
            }
        }

        contador = 0;
        for (int num : array) {
            if (num == candidato) {
                contador++;
            }
        }

        return (contador > array.length / 2) ? candidato : -1;
    }

    public static int encontrarMayoritarioBinario(int[] arrayOrdenado) {
        int n = arrayOrdenado.length;
        int candidato = arrayOrdenado[n / 2];

        int contador = 0;
        for (int num : arrayOrdenado) {
            if (num == candidato) {
                contador++;
            }
        }

        return (contador > n / 2) ? candidato : -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 1, 1, 1, 2, 2, 3 };

        int resultadoConteo = encontrarMayoritarioConteo(array);
        System.out.println("Elemento mayoritario (conteo): " + resultadoConteo);

        int resultadoBoyerMoore = encontrarMayoritarioBoyerMoore(array);
        System.out.println("Elemento mayoritario (Boyer-Moore): " + resultadoBoyerMoore);

        int resultadoBinario = encontrarMayoritarioBinario(array);
        System.out.println("Elemento mayoritario (binario): " + resultadoBinario);
    }
}