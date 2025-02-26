public class ContadorInversiones {
    private static int contarInversiones(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int inicio, int fin) {
        int contador = 0;
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            contador += mergeSort(nums, inicio, medio);
            contador += mergeSort(nums, medio + 1, fin);
            contador += fusionar(nums, inicio, medio, fin);
        }
        return contador;
    }

    private static int fusionar(int[] nums, int inicio, int medio, int fin) {
        int[] temp = new int[fin - inicio + 1];
        int i = inicio, j = medio + 1, k = 0, contador = 0;
        while (i <= medio && j <= fin) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                contador += (medio - i + 1);
            }
        }
        while (i <= medio) temp[k++] = nums[i++];
        while (j <= fin) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, inicio, temp.length);
        return contador;
    }

    public static void main(String[] args) {
        int[] entrada = {2, 4, 1, 3, 5};
        System.out.println(contarInversiones(entrada));
    }
}