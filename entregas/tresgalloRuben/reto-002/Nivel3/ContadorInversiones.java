package Nivel3;

public class ContadorInversiones {
    public static int contarInversiones(int[] numeros) {
        return mergeSortContarInversiones(numeros, new int[numeros.length], 0, numeros.length - 1);
    }

    private static int mergeSortContarInversiones(int[] numeros, int[] temp, int izquierda, int derecha) {
        if (izquierda >= derecha) return 0;

        int medio = (izquierda + derecha) / 2;
        int inversiones = 0;

        inversiones += mergeSortContarInversiones(numeros, temp, izquierda, medio);
        inversiones += mergeSortContarInversiones(numeros, temp, medio + 1, derecha);
        inversiones += merge(numeros, temp, izquierda, medio, derecha);

        return inversiones;
    }

    private static int merge(int[] numeros, int[] temp, int izquierda, int medio, int derecha) {
        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;
        int inversiones = 0;

        while (i <= medio && j <= derecha) {
            if (numeros[i] <= numeros[j]) {
                temp[k++] = numeros[i++];
            } else {
                temp[k++] = numeros[j++];
                inversiones += (medio + 1 - i); 
            }
        }

        while (i <= medio) {
            temp[k++] = numeros[i++];
        }

        while (j <= derecha) {
            temp[k++] = numeros[j++];
        }

        for (i = izquierda; i <= derecha; i++) {
            numeros[i] = temp[i];
        }

        return inversiones;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};
        int inversiones = contarInversiones(numeros);
        System.out.println("Número de inversiones: " + inversiones);
    }
}
