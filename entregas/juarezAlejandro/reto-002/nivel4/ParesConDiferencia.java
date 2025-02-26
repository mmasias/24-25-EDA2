package nivel4;

public class ParesConDiferencia {
    public static void main(String[] args) {
        int[] entrada = { 1, 7, 5, 9, 2, 12, 3 };
        int k = 2;
        int[][] resultado = encontrarParesConDiferencia(entrada, k);
        for (int i = 0; i < resultado.length; i++) {
            System.out.println("[" + resultado[i][0] + ", " + resultado[i][1] + "]");
        }
    }

    public static int[][] encontrarParesConDiferencia(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }

        int[][] pares = new int[count][2];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && Math.abs(nums[i] - nums[j]) == k) {
                    pares[index][0] = nums[i];
                    pares[index][1] = nums[j];
                    index++;
                }
            }
        }

        return pares;
    }
}