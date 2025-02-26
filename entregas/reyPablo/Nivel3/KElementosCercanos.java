public class KElementosCercanos {
    public static int[] encontrarCercanos(int[] nums, int k, int target) {
        int izquierda = 0, derecha = nums.length - k;
        while (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            if (target - nums[medio] > nums[medio + k] - target) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = nums[izquierda + i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] entrada = {1, 2, 3, 4, 5};
        int k = 2, target = 3;
        int[] salida = encontrarCercanos(entrada, k, target);
        for (int num : salida) System.out.print(num + " ");
    }
}