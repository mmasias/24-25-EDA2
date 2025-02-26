import java.util.PriorityQueue;

public class MedianaStream {
    private PriorityQueue<Integer> maxHeap; // Mitad inferior
    private PriorityQueue<Integer> minHeap; // Mitad superior

    public MedianaStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void agregarNumero(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double encontrarMediana() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianaStream stream = new MedianaStream();
        int[] numeros = {1, 3, 2, 4, 5};
        for (int num : numeros) {
            stream.agregarNumero(num);
            System.out.println("Mediana actual: " + stream.encontrarMediana());
        }
    }
}