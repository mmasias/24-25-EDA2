package EjerciciosAlgoritmos;

public class ContadorDeInversiones {

    public static int contarInversiones(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return contarInversiones(array, 0, array.length - 1);
    }

    private static int contarInversiones(int[] array, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return 0;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        int inversiones = contarInversiones(array, izquierda, medio) + contarInversiones(array, medio + 1, derecha);
        inversiones += merge(array, izquierda, medio, derecha);
        return inversiones;
    }

    private static int merge(int[] array, int izquierda, int medio, int derecha) {
        int[] temp = new int[derecha - izquierda + 1];
        int indiceIzquierda = izquierda, indiceDerecha = medio + 1, indiceTemp = 0, inversiones = 0;

        while (indiceIzquierda <= medio && indiceDerecha <= derecha) {
            if (array[indiceIzquierda] <= array[indiceDerecha]) {
                temp[indiceTemp++] = array[indiceIzquierda++];
            } else {
                temp[indiceTemp++] = array[indiceDerecha++];
                inversiones += (medio - indiceIzquierda + 1); 
            }
        }

        while (indiceIzquierda <= medio) {
            temp[indiceTemp++] = array[indiceIzquierda++];
        }

        while (indiceDerecha <= derecha) {
            temp[indiceTemp++] = array[indiceDerecha++];
        }

        System.arraycopy(temp, 0, array, izquierda, temp.length);
        return inversiones;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int resultado = contarInversiones(arr);
        System.out.println("Número de inversiones: " + resultado);
    }
}