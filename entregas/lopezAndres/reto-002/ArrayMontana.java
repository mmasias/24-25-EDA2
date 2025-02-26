public class ArrayMontana {
    public static boolean esMontana(int[] nums) {
        if (nums.length < 3) return false;
        
        int i = 0;
        while (i + 1 < nums.length && nums[i] < nums[i + 1]) i++;
        if (i == 0 || i == nums.length - 1) return false;
        while (i + 1 < nums.length && nums[i] > nums[i + 1]) i++;
        
        return i == nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        System.out.println("Es montaña: " + esMontana(nums));
    }
}
