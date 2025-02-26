package entregas.Reyes_David.Reto_002.Nivel3;

public class ContadorInversiones {
    private static int contarInversiones(int[] array, int[] temp, int izquierda, int derecha) {
        int contador = 0;
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            contador += contarInversiones(array, temp, izquierda, medio);
            contador += contarInversiones(array, temp, medio + 1, derecha);
            contador += merge(array, temp, izquierda, medio + 1, derecha);
        }
        return contador;
    }

    private static int merge(int[] array, int[] temp, int izquierda, int medio, int derecha) {
        int i = izquierda;
        int j = medio;
        int k = izquierda;
        int contador = 0;

        while (i <= medio - 1 && j <= derecha) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                contador += (medio - i);
            }
        }

        while (i <= medio - 1) {
            temp[k++] = array[i++];
        }

        while (j <= derecha) {
            temp[k++] = array[j++];
        }

        for (i = izquierda; i <= derecha; i++) {
            array[i] = temp[i];
        }

        return contador;
    }

    public static int contarInversiones(int[] array) {
        int[] temp = new int[array.length];
        return contarInversiones(array, temp, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 3, 5};
        int inversiones = contarInversiones(array);
        System.out.println("Número de inversiones: " + inversiones);
    }
}
