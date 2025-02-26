public class Subconjuntos {
    public void generarSubconjuntos(int[] nums, int index, String conjunto) {
        if (index == nums.length) {
            System.out.println("[" + conjunto.trim() + "]");
            return;
        }
        generarSubconjuntos(nums, index + 1, conjunto + nums[index] + " ");
        generarSubconjuntos(nums, index + 1, conjunto);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        new Subconjuntos().generarSubconjuntos(arr, 0, "");
    }
}
