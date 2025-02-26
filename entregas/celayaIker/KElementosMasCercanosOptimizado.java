package entregas.celayaIker;

public class KElementosMasCercanosOptimizado {
    public static int[] encontrarMasCercanos(int[] nums, int k, double target) {
        int izquierda = 0, derecha = nums.length - 1;

        while (izquierda < derecha) {
            int mid = izquierda + (derecha - izquierda) / 2;
            if (nums[mid] < target) {
                izquierda = mid + 1;
            } else {
                derecha = mid;
            }
        }

        int low = izquierda - 1, high = izquierda;

        while (k > 0) {
            if (low < 0) {
                high++;
            } else if (high >= nums.length || Math.abs(nums[low] - target) <= Math.abs(nums[high] - target)) {
                low--;
            } else {
                high++;
            }
            k--;
        }

        int[] resultado = new int[high - low - 1];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = nums[low + 1 + i];
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] resultado = encontrarMasCercanos(nums, k, target);

        System.out.print("K elementos más cercanos: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
