public class NumeroFaltante {
    public static int findMissing(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n + 1) / 2;
        int suma = 0;
        for (int num : nums) suma += num;
        return total - suma;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        System.out.println(findMissing(nums));
    }
}