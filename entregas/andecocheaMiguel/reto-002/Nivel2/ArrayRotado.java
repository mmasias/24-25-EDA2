public class ArrayRotado {

    public static int encontrarPuntoRotacionLineal(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int encontrarPuntoRotacionBinario(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;

        if (array[izquierda] < array[derecha]) {
            return 0;
        }

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (medio < array.length - 1 && array[medio] > array[medio + 1]) {
                return medio + 1;
            }

            if (medio > 0 && array[medio - 1] > array[medio]) {
                return medio;
            }

            if (array[medio] > array[0]) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return 0;
    }

    public static int encontrarPuntoRotacionConDuplicados(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;

        if (array[izquierda] < array[derecha]) {
            return 0;
        }

        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (medio < array.length - 1 && array[medio] > array[medio + 1]) {
                return medio + 1;
            }

            if (array[izquierda] == array[medio] && array[medio] == array[derecha]) {
                if (izquierda < array.length - 1 && array[izquierda] > array[izquierda + 1]) {
                    return izquierda + 1;
                }
                izquierda++;

                if (derecha > 0 && array[derecha - 1] > array[derecha]) {
                    return derecha;
                }
                derecha--;
            }
            else if (array[izquierda] <= array[medio]) {
                if (array[izquierda] == array[medio]) {
                    if (array[medio] > array[derecha]) {
                        izquierda = medio + 1;
                    } else {
                        derecha = medio - 1;
                    }
                } else {
                    izquierda = medio + 1;
                }
            } else {
                derecha = medio;
            }
        }

        return izquierda;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 2, 3};

        int resultadoLineal = encontrarPuntoRotacionLineal(array);
        System.out.println("Punto rotación (lineal): " + resultadoLineal);

        int resultadoBinario = encontrarPuntoRotacionBinario(array);
        System.out.println("Punto rotación (binario): " + resultadoBinario);

        int[] arrayDuplicados = {4, 4, 5, 6, 1, 2, 3, 3};
        int resultadoDuplicados = encontrarPuntoRotacionConDuplicados(arrayDuplicados);
        System.out.println("Punto rotación (duplicados): " + resultadoDuplicados);
    }
}