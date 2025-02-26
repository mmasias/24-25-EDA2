import java.util.PriorityQueue;

public class KElementosCercanos {
    public static int[] encontrarKCercanos(int[] nums, int k, double target) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(b[0] - target), Math.abs(a[0] - target)));

        for (int num : nums) {
            maxHeap.offer(new int[]{num});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = maxHeap.poll()[0];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] resultado = encontrarKCercanos(nums, 2, 3.7);
        System.out.println(java.util.Arrays.toString(resultado));
    }
}