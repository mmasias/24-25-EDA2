public class Subconjuntos {
    public static void generarSubconjuntos(int[] nums, int index, String actual) {
        if (index == nums.length) {
            System.out.println("[" + actual + "]");
            return;
        }
        generarSubconjuntos(nums, index + 1, actual + (actual.isEmpty() ? "" : ", ") + nums[index]);
        generarSubconjuntos(nums, index + 1, actual);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generarSubconjuntos(nums, 0, "");
    }
}