package entregas.celayaIker;

import java.util.Arrays;

public class ParesConDiferencia {
    public static void encontrarPares(int[] nums, int k) {
        Arrays.sort(nums);
        int izquierda = 0, derecha = 1;
        int n = nums.length;

        System.out.print("Pares con diferencia " + k + ": [");

        while (derecha < n) {
            int diferencia = nums[derecha] - nums[izquierda];

            if (diferencia == k) {
                System.out.print("[" + nums[izquierda] + ", " + nums[derecha] + "]");
                if (derecha < n - 1) System.out.print(", ");
                izquierda++;
                derecha++;
            } else if (diferencia < k) {
                derecha++; 
            } else {
                izquierda++; 
                if (izquierda == derecha) derecha++;
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        encontrarPares(nums, k);
    }
}
