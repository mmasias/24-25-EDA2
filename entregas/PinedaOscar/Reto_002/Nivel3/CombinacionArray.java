package entregas.PinedaOscar.Reto_002.Nivel3;

import java.util.PriorityQueue;

public class CombinacionArray {
    public static int[] combinarArrays(int[][] arrays) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] array : arrays) {
            for (int num : array) {
                minHeap.offer(num);
            }
        }

        int[] resultado = new int[minHeap.size()];
        int index = 0;
        while (!minHeap.isEmpty()) {
            resultado[index++] = minHeap.poll();
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] resultado = combinarArrays(arrays);
        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}