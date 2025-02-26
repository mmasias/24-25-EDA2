import java.util.PriorityQueue;

public class CasiOrdenado {
    public static int[] ordenarCasiOrdenado(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] resultado = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                resultado[index++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            resultado[index++] = minHeap.poll();
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4};
        int[] resultado = ordenarCasiOrdenado(nums, 2);
        System.out.println(java.util.Arrays.toString(resultado));
    }
}