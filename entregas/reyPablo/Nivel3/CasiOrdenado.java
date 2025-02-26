public class CasiOrdenado {
    public static void ordenar(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] entrada = {2, 1, 3, 5, 4};
        int k = 2;
        ordenar(entrada, k);
        for (int num : entrada) System.out.print(num + " ");
    }
}