package entregas.celayaIker;

public class Inversiones2 {
    public static int contarInversionesMergeSort(int[] nums) {
        int[] aux = new int[nums.length];
        return mergeSort(nums, aux, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int[] aux, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return 0;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        int inversiones = 0;

        inversiones += mergeSort(nums, aux, izquierda, medio);
        inversiones += mergeSort(nums, aux, medio + 1, derecha);

        inversiones += merge(nums, aux, izquierda, medio, derecha);

        return inversiones;
    }

    private static int merge(int[] nums, int[] aux, int izquierda, int medio, int derecha) {
        for (int i = izquierda; i <= derecha; i++) {
            aux[i] = nums[i];
        }

        int i = izquierda, j = medio + 1, k = izquierda, inversiones = 0;

        while (i <= medio && j <= derecha) {
            if (aux[i] <= aux[j]) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
                inversiones += (medio - i + 1); 
            }
        }

        while (i <= medio) {
            nums[k++] = aux[i++];
        }

        return inversiones;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        int totalInversiones = contarInversionesMergeSort(nums);
        System.out.println("Total de inversiones: " + totalInversiones);
    }
}
