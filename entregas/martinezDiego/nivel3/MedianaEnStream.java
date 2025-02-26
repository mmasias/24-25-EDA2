package entregas.martinezDiego.nivel3;

import java.util.PriorityQueue;

public class MedianaEnStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianaEnStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        minHeap = new PriorityQueue<>();
    }

    public void agregarNumero(int numero) {
        if (maxHeap.isEmpty() || numero <= maxHeap.peek()) {
            maxHeap.offer(numero);
        } else {
            minHeap.offer(numero);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double obtenerMediana() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianaEnStream medianaEnFlujo = new MedianaEnStream();
        int[] numeros = {1, 3, 2, 4, 5};

        System.out.print("Entrada: ");
        for (int i = 0; i < numeros.length; i++) {
            medianaEnFlujo.agregarNumero(numeros[i]);
            System.out.print(medianaEnFlujo.obtenerMediana());
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

