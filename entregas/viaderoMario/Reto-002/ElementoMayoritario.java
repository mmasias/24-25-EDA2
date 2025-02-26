public class ElementoMayoritario {
    public static int encontrarMayoritario(int[] nums) {
        int n = nums.length;
        return nums[n / 2]; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        System.out.println("Elemento mayoritario: " + encontrarMayoritario(nums));
    }
}
