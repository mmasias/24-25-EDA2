import java.util.Collections;
import java.util.PriorityQueue;

public class MedianaStream {
    private PriorityQueue<Integer> menor = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> mayor = new PriorityQueue<>();

    public void agregarNumero(int num) {
        menor.offer(num);
        mayor.offer(menor.poll());
        if (menor.size() < mayor.size()) {
            menor.offer(mayor.poll());
        }
    }

    public double obtenerMediana() {
        if (menor.size() > mayor.size()) {
            return menor.peek();
        }
        return (menor.peek() + mayor.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianaStream stream = new MedianaStream();
        int[] nums = {1, 3, 2, 4, 5};
        for (int num : nums) {
            stream.agregarNumero(num);
            System.out.println("Mediana actual: " + stream.obtenerMediana());
        }
    }
}