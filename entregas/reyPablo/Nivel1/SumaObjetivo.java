public class SumaObjetivo {
    public static int[] findIndices(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 9, 8};
        int target = 10;
        int[] result = findIndices(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}