import java.util.*;

public class CombinacionArrays {
    public static List<Integer> combinarArrays(List<int[]> arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<Integer> resultado = new ArrayList<>();
        
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).length > 0) {
                minHeap.offer(new int[]{arrays.get(i)[0], i, 0});
            }
        }

        while (!minHeap.isEmpty()) {
            int[] actual = minHeap.poll();
            resultado.add(actual[0]);
            int arrayIndex = actual[1], elementoIndex = actual[2];

            if (elementoIndex + 1 < arrays.get(arrayIndex).length) {
                minHeap.offer(new int[]{arrays.get(arrayIndex)[elementoIndex + 1], arrayIndex, elementoIndex + 1});
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<int[]> arrays = Arrays.asList(
            new int[]{1, 4, 7},
            new int[]{2, 5, 8},
            new int[]{3, 6, 9}
        );
        System.out.println(combinarArrays(arrays));
    }
}
