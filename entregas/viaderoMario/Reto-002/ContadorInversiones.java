public class ContadorInversiones {
    private static int mergeSort(int[] arr, int[] temp, int izquierda, int derecha) {
        if (izquierda >= derecha) return 0;
        int medio = (izquierda + derecha) / 2;
        int conteo = mergeSort(arr, temp, izquierda, medio) + mergeSort(arr, temp, medio + 1, derecha);
        conteo += merge(arr, temp, izquierda, medio, derecha);
        return conteo;
    }

    private static int merge(int[] arr, int[] temp, int izquierda, int medio, int derecha) {
        int i = izquierda, j = medio + 1, k = izquierda, conteo = 0;
        while (i <= medio && j <= derecha) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                conteo += (medio + 1 - i);
            }
        }
        while (i <= medio) temp[k++] = arr[i++];
        while (j <= derecha) temp[k++] = arr[j++];
        System.arraycopy(temp, izquierda, arr, izquierda, derecha - izquierda + 1);
        return conteo;
    }

    public static int contarInversiones(int[] nums) {
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        System.out.println("Número de inversiones: " + contarInversiones(nums));
    }
}