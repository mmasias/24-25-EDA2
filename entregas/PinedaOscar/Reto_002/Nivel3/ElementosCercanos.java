package entregas.PinedaOscar.Reto_002.Nivel3;

import java.util.PriorityQueue;

public class ElementosCercanos {
    public static int[] encontrarKElementosCercanos(int[] array, int k, int target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> 
            Math.abs(b - target) - Math.abs(a - target)
        );

        for (int num : array) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] resultado = new int[k];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            resultado[index++] = maxHeap.poll();
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 2;
        int target = 3;
        int[] resultado = encontrarKElementosCercanos(array, k, target);
        System.out.print("K elementos más cercanos: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}