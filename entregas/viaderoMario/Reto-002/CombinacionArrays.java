import java.util.PriorityQueue;

public class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int totalSize = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0});
                totalSize += arrays[i].length;
            }
        }

        int[] resultado = new int[totalSize];
        int index = 0;

        while (!minHeap.isEmpty()) {
            int[] actual = minHeap.poll();
            resultado[index++] = actual[0];
            int arrayIndex = actual[1], elementIndex = actual[2];

            if (elementIndex + 1 < arrays[arrayIndex].length) {
                minHeap.offer(new int[]{arrays[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[] resultado = combinarArrays(arrays);
        System.out.println(java.util.Arrays.toString(resultado));
    }
}
