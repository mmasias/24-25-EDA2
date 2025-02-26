public class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] nums) {
        int sumaTotal = 0;
        for (int num : nums) {
            sumaTotal += num;
        }

        int sumaIzquierda = 0;
        for (int i = 0; i < nums.length; i++) {
            sumaTotal -= nums[i];
            if (sumaIzquierda == sumaTotal) {
                return i;
            }
            sumaIzquierda += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        System.out.println(encontrarPuntoEquilibrio(nums));
    }
}