package entregas.celayaIker;

public class Inversiones {
    public static void contarInversiones(int[] nums) {
        int n = nums.length;
        int contador = 0;

        System.out.print("Inversiones: ");
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    System.out.print("(" + nums[i] + "," + nums[j] + ") ");
                    contador++;
                }
            }
        }
        
        System.out.println("\nTotal de inversiones: " + contador);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        contarInversiones(nums);
    }
}
