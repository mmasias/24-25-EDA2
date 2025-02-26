public class Subconjuntos {
    public static void generarSubconjuntos(int[] nums, int index, String subconjunto) {
        if (index == nums.length) {
            System.out.println("[" + subconjunto + "]");
            return;
        }
        generarSubconjuntos(nums, index + 1, subconjunto);
        generarSubconjuntos(nums, index + 1, subconjunto + (subconjunto.isEmpty() ? "" : ",") + nums[index]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generarSubconjuntos(nums, 0, "");
    }
}