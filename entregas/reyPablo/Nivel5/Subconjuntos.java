public class Subconjuntos {
    public static void generar(int[] nums, int index, int[] actual, int len) {
        if (index == nums.length) {
            System.out.print("[");
            for (int i = 0; i < len; i++) {
                System.out.print(actual[i] + (i < len - 1 ? ", " : ""));
            }
            System.out.println("]");
            return;
        }
        generar(nums, index + 1, actual, len);
        actual[len] = nums[index];
        generar(nums, index + 1, actual, len + 1);
    }
    
    public static void main(String[] args) {
        int[] entrada = {1, 2, 3};
        int[] actual = new int[entrada.length];
        generar(entrada, 0, actual, 0);
    }
}
