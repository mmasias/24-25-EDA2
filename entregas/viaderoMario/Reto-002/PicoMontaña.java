public class PicoMontaña {
    public static int encontrarPico(int[] nums) {
        int izquierda = 0, derecha = nums.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (nums[medio] < nums[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        return nums[izquierda];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 6, 4, 2};
        System.out.println("Elemento pico: " + encontrarPico(nums));
    }
}