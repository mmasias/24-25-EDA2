public class ParesConDiferencia {
    public String encontrarPares(int[] nums, int k) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + k == nums[j]) {
                    resultado.append("(").append(nums[i]).append(", ").append(nums[j]).append(") ");
                }
            }
        }
        return resultado.toString();
    }
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        System.out.println(new ParesConDiferencia().encontrarPares(arr, 2));
    }
}