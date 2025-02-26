public class SubconjuntosK {
    public static void generarSubconjuntosK(int[] nums, int k, int index, String subconjunto) {
        if (subconjunto.length() / 2 == k) {
            System.out.println("[" + subconjunto + "]");
            return;
        }
        if (index == nums.length) return;
        generarSubconjuntosK(nums, k, index + 1, subconjunto);
        generarSubconjuntosK(nums, k, index + 1, subconjunto + (subconjunto.isEmpty() ? "" : ",") + nums[index]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        generarSubconjuntosK(nums, k, 0, "");
    }
}