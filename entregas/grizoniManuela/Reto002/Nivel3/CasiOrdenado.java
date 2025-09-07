package Reto002.Nivel3;

public class CasiOrdenado {
    static class MinHeap {
        int[] heap;
        int size;
        
        public MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }
        
        public void insert(int val) {
            heap[size] = val;
            size++;
            heapifyUp(size - 1);
        }
        
        public int extractMin() {
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return min;
        }
        
        private void heapifyUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap[index] < heap[parent]) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }
        
        private void heapifyDown(int index) {
            while (index < size) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;
                if (left < size && heap[left] < heap[smallest]) {
                    smallest = left;
                }
                if (right < size && heap[right] < heap[smallest]) {
                    smallest = right;
                }
                if (smallest != index) {
                    swap(index, smallest);
                    index = smallest;
                } else {
                    break;
                }
            }
        }
        
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
    
    public static void sortNearlySorted(int[] arr, int k) {
        int n = arr.length;
        int heapCapacity = Math.min(k + 1, n);
        MinHeap heap = new MinHeap(heapCapacity);
        for (int i = 0; i < heapCapacity; i++) {
            heap.insert(arr[i]);
        }
        int index = 0;
        for (int i = heapCapacity; i < n; i++) {
            arr[index++] = heap.extractMin();
            heap.insert(arr[i]);
        }
        while (heap.size > 0) {
            arr[index++] = heap.extractMin();
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        int k = 2;
        sortNearlySorted(arr, k);
        System.out.print("Salida: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
