package entregas.celayaIker;

public class ElementoUnico {
    public static int encontrarUnico(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        int[] conteo = new int[max + 1];

        for (int num : nums) {
            conteo[num]++;
        }

        for (int num : nums) {
            if (conteo[num] == 1) {
                return num;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2};
        int unico = encontrarUnico(nums);

        System.out.println("Elemento único: " + unico);
    }
}
