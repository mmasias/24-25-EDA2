import java.util.Arrays;

public class SumaMaxima {
    public int[] subarregloMaximo(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0], start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(nums, start, end + 1);
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(new SumaMaxima().subarregloMaximo(arr)));
    }
}