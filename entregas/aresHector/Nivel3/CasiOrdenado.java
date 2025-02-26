import java.util.*;

public class CasiOrdenado {
    public static int[] ordenarCasiOrdenado(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] resultado = new int[arr.length];
        int index = 0;

        for (int num : arr) {
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
        int[] arr = {2, 1, 3, 5, 4};
        System.out.println(Arrays.toString(ordenarCasiOrdenado(arr, 2)));
    }
}
