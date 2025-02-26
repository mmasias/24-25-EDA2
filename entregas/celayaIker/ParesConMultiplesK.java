package entregas.celayaIker;

import java.util.Arrays;

public class ParesConMultiplesK {
    public static void encontrarPares(int[] nums, int[] kValores) {
        Arrays.sort(nums); 

        for (int k : kValores) {
            System.out.print("Pares con diferencia " + k + ": [");
            int izquierda = 0, derecha = 1;
            int n = nums.length;
            boolean encontrado = false;

            while (derecha < n) {
                int diferencia = nums[derecha] - nums[izquierda];

                if (diferencia == k) {
                    System.out.print("[" + nums[izquierda] + ", " + nums[derecha] + "]");
                    encontrado = true;
                    izquierda++;
                    derecha++;
                } else if (diferencia < k) {
                    derecha++;
                } else {
                    izquierda++;
                    if (izquierda == derecha) derecha++;
                }
                if (encontrado && derecha < n) System.out.print(", ");
            }
            System.out.println(encontrado ? "]" : "No hay pares]");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        int[] kValores = {2, 4, 6}; 
        encontrarPares(nums, kValores);
    }
}
