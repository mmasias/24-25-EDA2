public class ParesConDiferencia {
    public static void encontrarPares(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    System.out.println(nums[i] + ", " + nums[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        encontrarPares(nums, k);
    }
}