public class ElementoUnico {
    public static int encontrarUnico(int[] nums) {
        int unico = 0;
        for (int num : nums) {
            unico ^= num;
        }
        return unico;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2};
        System.out.println("Elemento único: " + encontrarUnico(nums));
    }
}
