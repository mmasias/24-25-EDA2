package entregas.Reyes_David.Reto_002.Nivel3;

import java.util.PriorityQueue;

public class CasiOrdenado {
    public static int[] ordenarCasiOrdenado(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] resultado = new int[array.length];
        int index = 0;

        for (int i = 0; i <= k; i++) {
            minHeap.offer(array[i]);
        }

        for (int i = k + 1; i < array.length; i++) {
            resultado[index++] = minHeap.poll();
            minHeap.offer(array[i]);
        }

        while (!minHeap.isEmpty()) {
            resultado[index++] = minHeap.poll();
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4};
        int k = 2;
        int[] resultado = ordenarCasiOrdenado(array, k);
        System.out.print("Array ordenado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}