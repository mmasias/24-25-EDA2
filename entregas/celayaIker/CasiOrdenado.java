package entregas.celayaIker;

public class CasiOrdenado {
    public static void ordenarCasiOrdenado(int[] nums, int k) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int clave = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > clave && j >= i - k) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarCasiOrdenado(nums, k);

        System.out.println("k = " + k);

        System.out.print("Array ordenado: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
