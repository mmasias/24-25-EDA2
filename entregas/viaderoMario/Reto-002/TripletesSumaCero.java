import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletesSumaCero {
    public static List<List<Integer>> encontrarTripletes(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultado = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int izquierda = i + 1, derecha = n - 1;

            while (izquierda < derecha) {
                int suma = nums[i] + nums[izquierda] + nums[derecha];

                if (suma == 0) {
                    resultado.add(Arrays.asList(nums[i], nums[izquierda], nums[derecha]));
                    while (izquierda < derecha && nums[izquierda] == nums[izquierda + 1]) izquierda++;
                    while (izquierda < derecha && nums[derecha] == nums[derecha - 1]) derecha--;
                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(encontrarTripletes(nums));
    }
}