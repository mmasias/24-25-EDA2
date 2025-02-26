package entregas.celayaIker;

import java.util.Arrays;

public class TripletesSumaCero {
    public static void encontrarTripletes(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            System.out.println("No hay suficientes números para formar tripletes.");
            return;
        }

        Arrays.sort(nums);
        boolean encontrado = false;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; 

            int izquierda = i + 1;
            int derecha = n - 1;

            while (izquierda < derecha) {
                int suma = nums[i] + nums[izquierda] + nums[derecha];

                if (suma == 0) {
                    System.out.println("[" + nums[i] + ", " + nums[izquierda] + ", " + nums[derecha] + "]");
                    encontrado = true;

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

        if (!encontrado) {
            System.out.println("No hay tripletes que sumen cero.");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Tripletes suma cero:");
        encontrarTripletes(nums);
    }
}
