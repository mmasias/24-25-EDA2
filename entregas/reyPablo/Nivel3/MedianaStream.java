public class MedianaStream {
    private static int[] maxHeap = new int[100];
    private static int[] minHeap = new int[100];
    private static int maxSize = 0, minSize = 0;

    public static void insertar(int num) {
        if (maxSize == 0 || num <= maxHeap[0]) {
            maxHeap[maxSize++] = num;
            if (maxSize > minSize + 1) {
                minHeap[minSize++] = maxHeap[0];
                maxHeap[0] = maxHeap[--maxSize];
            }
        } else {
            minHeap[minSize++] = num;
            if (minSize > maxSize) {
                maxHeap[maxSize++] = minHeap[0];
                minHeap[0] = minHeap[--minSize];
            }
        }
    }

    public static double mediana() {
        if (maxSize > minSize) return maxHeap[0];
        return (maxHeap[0] + minHeap[0]) / 2.0;
    }

    public static void main(String[] args) {
        int[] entrada = {1, 3, 2, 4, 5};
        for (int num : entrada) {
            insertar(num);
            System.out.print(mediana() + " ");
        }
    }
}