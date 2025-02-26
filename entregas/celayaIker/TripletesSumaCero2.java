package entregas.celayaIker;

public class TripletesSumaCero2 {
    public static void encontrarTripletes(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            System.out.println("No hay suficientes números para formar tripletes.");
            return;
        }

        boolean encontrado = false;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int objetivo = -(nums[i] + nums[j]);

                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == objetivo) {
                        System.out.println("[" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
                        encontrado = true;
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay tripletes que sumen cero.");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Tripletes suma cero (Alternativa sin ordenar):");
        encontrarTripletes(nums);
    }
}
