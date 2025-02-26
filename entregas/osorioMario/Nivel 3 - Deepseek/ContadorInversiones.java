public class ContadorInversiones {
    private static int contarInversiones(int[] numeros) {
        return mergeSort(numeros, 0, numeros.length - 1);
    }

    private static int mergeSort(int[] numeros, int inicio, int fin) {
        int contador = 0;
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            contador += mergeSort(numeros, inicio, medio);
            contador += mergeSort(numeros, medio + 1, fin);
            contador += fusionar(numeros, inicio, medio, fin);
        }
        return contador;
    }

    private static int fusionar(int[] numeros, int inicio, int medio, int fin) {
        int[] temp = new int[fin - inicio + 1];
        int i = inicio, j = medio + 1, k = 0;
        int contador = 0;
        while (i <= medio && j <= fin) {
            if (numeros[i] <= numeros[j]) {
                temp[k++] = numeros[i++];
            } else {
                temp[k++] = numeros[j++];
                contador += (medio - i + 1);
            }
        }
        while (i <= medio) temp[k++] = numeros[i++];
        while (j <= fin) temp[k++] = numeros[j++];
        System.arraycopy(temp, 0, numeros, inicio, temp.length);
        return contador;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};
        int inversiones = contarInversiones(numeros);
        System.out.println("Número de inversiones: " + inversiones);
    }
}