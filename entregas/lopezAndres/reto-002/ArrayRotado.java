public class ArrayRotado {
    public static int encontrarRotacion(int[] nums) {
        int izquierda = 0, derecha = nums.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (nums[medio] > nums[derecha]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        return izquierda;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        System.out.println("Punto de rotación en índice: " + encontrarRotacion(nums));
    }
}
