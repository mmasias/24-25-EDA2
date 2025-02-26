public class TriangulosPosibles {
    public static void encontrarTriangulos(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k] &&
                        nums[i] + nums[k] > nums[j] &&
                        nums[j] + nums[k] > nums[i]) {
                        System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7};
        encontrarTriangulos(nums);
    }
}