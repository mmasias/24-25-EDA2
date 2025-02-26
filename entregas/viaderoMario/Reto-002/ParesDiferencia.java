import java.util.ArrayList;
import java.util.List;

public class ParesDiferencia {
    public static List<int[]> encontrarPares(int[] nums, int k) {
        List<int[]> resultado = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    resultado.add(new int[]{nums[i], nums[j]});
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        System.out.println(encontrarPares(nums, 2));
    }
}