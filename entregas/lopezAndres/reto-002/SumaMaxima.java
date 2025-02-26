public class SumaMaxima {
    public static int[] subarrayMaximaSuma(int[] nums) {
        int n = nums.length;
        int maxSuma = Integer.MIN_VALUE, inicio = 0, fin = 0;

        for (int i = 0; i < n; i++) {
            int sumaActual = 0;
            for (int j = i; j < n; j++) {
                sumaActual += nums[j];
                if (sumaActual > maxSuma) {
                    maxSuma = sumaActual;
                    inicio = i;
                    fin = j;
                }
            }
        }
        return java.util.Arrays.copyOfRange(nums, inicio, fin + 1);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(java.util.Arrays.toString(subarrayMaximaSuma(nums)));
    }
}
