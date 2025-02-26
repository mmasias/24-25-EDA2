package entregas.celayaIker;

public class ArrayMontaña {
    public static boolean esMontana(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) return false;

        while (i < n - 1 && nums[i] > nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2}; 
        System.out.println("Es montaña: " + esMontana(nums));
    }
}
