package Nivel1;

public class SumaObjetivo {
    public static int[] sumaObjetivo(int[] nums, int objetivo) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == objetivo) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 9, 8};
        int objetivo = 10;
        int[] resultado = sumaObjetivo(nums, objetivo);
        System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "]");
    }
}
