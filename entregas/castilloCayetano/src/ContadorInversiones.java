public class ContadorInversiones {
// Completado 
// ???
    public static void main(String[] args) {
        imprimirContadorInversiones();
    }
    public void mostrar(){
        imprimirContadorInversiones();
    }
    public static void imprimirContadorInversiones() {
        int[] array = {2, 4, 1, 3, 5};
        int count = contarInversiones(array);
        System.out.println("Número de pares en orden incorrecto: " + count);
    }

    public static int contarInversiones(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeSortAndCount(array, 0, array.length - 1);
    }

    private static int mergeSortAndCount(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSortAndCount(array, left, mid);
        count += mergeSortAndCount(array, mid + 1, right);
        count += mergeAndCount(array, left, mid, right);
        return count;
    }

    private static int mergeAndCount(int[] array, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }

        return swaps;
    }
}