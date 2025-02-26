public class ContadorInversiones {
    private static int contarInversiones(int[] numeros) {
        return mergeSort(numeros, 0, numeros.length - 1);
    }

    private static int mergeSort(int[] numeros, int izquierda, int derecha) {
        int contador = 0;
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            contador += mergeSort(numeros, izquierda, medio);
            contador += mergeSort(numeros, medio + 1, derecha);
            contador += merge(numeros, izquierda, medio, derecha);
        }
        return contador;
    }

    private static int merge(int[] numeros, int izquierda, int medio, int derecha) {
        int[] temp = new int[derecha - izquierda + 1];
        int i = izquierda, j = medio + 1, k = 0, contador = 0;
        while (i <= medio && j <= derecha) {
            if (numeros[i] <= numeros[j]) {
                temp[k++] = numeros[i++];
            } else {
                temp[k++] = numeros[j++];
                contador += (medio - i + 1);
            }
        }
        while (i <= medio) {
            temp[k++] = numeros[i++];
        }
        while (j <= derecha) {
            temp[k++] = numeros[j++];
        }
        for (i = izquierda; i <= derecha; i++) {
            numeros[i] = temp[i - izquierda];
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};
        System.out.println(contarInversiones(numeros));
    }
}