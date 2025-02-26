import java.util.*;

public class KCercanos {
    public static List<Integer> kMasCercanos(int[] arr, int k, double target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(b - target), Math.abs(a - target)));
        
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(kMasCercanos(arr, 2, 3.7)); // Output: [3, 4]
    }
}
