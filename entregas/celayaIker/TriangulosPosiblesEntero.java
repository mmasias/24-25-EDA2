package entregas.celayaIker;

import java.util.Arrays;

public class TriangulosPosiblesEntero {
    public static void encontrarTriangulos(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            System.out.println("No hay suficientes números para formar un triángulo.");
            return;
        }

        Arrays.sort(nums);
        boolean encontrado = false;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = i + 2;

            while (k < n) {
                if (nums[i] + nums[j] > nums[k]) {
                    System.out.println("(" + nums[i] + ", " + nums[j] + ", " + nums[k] + ")");
                    encontrado = true;
                }
                k++;
                if (k == n) { 
                    j++;
                    k = j + 1;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay tríos que formen un triángulo.");
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7};
        System.out.println("Tríangulos posibles:");
        encontrarTriangulos(nums);
    }
}
