package entregas.martinezDiego.nivel3;

public class CombinacionArrays {
    public static int[] combinarArraysOrdenados(int[][] arrays) {
        int longitud = 0;
        for (int[] array : arrays) {
            longitud += array.length;
        }

        int[] resultado = new int[longitud];
        int indice = 0;

        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length > 0 && arrays[i][0] < min) {
                    min = arrays[i][0];
                    minIndex = i;
                }
            }

            if (minIndex == -1) break;

            resultado[indice++] = min;
            arrays[minIndex] = quitarPrimero(arrays[minIndex]);
        }

        return resultado;
    }

    public static int[] quitarPrimero(int[] array) {
        int[] nuevoArray = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            nuevoArray[i - 1] = array[i];
        }
        return nuevoArray;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        System.out.print("Entrada: [");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j]);
                if (j < arrays[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < arrays.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int[] resultado = combinarArraysOrdenados(arrays);
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

