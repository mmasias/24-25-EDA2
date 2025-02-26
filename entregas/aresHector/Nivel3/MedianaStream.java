import java.util.*;

public class MedianaStream {
    private PriorityQueue<Integer> menores = new PriorityQueue<>(Collections.reverseOrder()); 
    private PriorityQueue<Integer> mayores = new PriorityQueue<>(); 

    public void agregarNumero(int num) {
        if (menores.isEmpty() || num <= menores.peek()) {
            menores.offer(num);
        } else {
            mayores.offer(num);
        }

        if (menores.size() > mayores.size() + 1) {
            mayores.offer(menores.poll());
        } else if (mayores.size() > menores.size()) {
            menores.offer(mayores.poll());
        }
    }

    public double obtenerMediana() {
        if (menores.size() == mayores.size()) {
            return (menores.peek() + mayores.peek()) / 2.0;
        }
        return menores.peek();
    }

    public static void main(String[] args) {
        MedianaStream stream = new MedianaStream();
        int[] numeros = {1, 3, 2, 4, 5};

        for (int num : numeros) {
            stream.agregarNumero(num);
            System.out.println(stream.obtenerMediana());
        }
    }
}
