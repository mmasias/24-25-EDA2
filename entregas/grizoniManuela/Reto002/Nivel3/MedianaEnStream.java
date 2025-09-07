package Reto002.Nivel3;

public class MedianaEnStream {
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
        public int peek() {
            return heap[0];
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
                if (left < size && heap[left] < heap[smallest])
                    smallest = left;
                if (right < size && heap[right] < heap[smallest])
                    smallest = right;
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
    static class MaxHeap {
        int[] heap;
        int size;
        public MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }
        public void insert(int val) {
            heap[size] = val;
            size++;
            heapifyUp(size - 1);
        }
        public int extractMax() {
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return max;
        }
        public int peek() {
            return heap[0];
        }
        private void heapifyUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap[index] > heap[parent]) {
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
                int largest = index;
                if (left < size && heap[left] > heap[largest])
                    largest = left;
                if (right < size && heap[right] > heap[largest])
                    largest = right;
                if (largest != index) {
                    swap(index, largest);
                    index = largest;
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
    static class MedianFinder {
        MaxHeap left;
        MinHeap right;
        int count;
        public MedianFinder(int capacity) {
            left = new MaxHeap(capacity);
            right = new MinHeap(capacity);
            count = 0;
        }
        public void addNumber(int num) {
            if (count == 0) {
                left.insert(num);
            } else {
                if (num <= left.peek()) {
                    left.insert(num);
                } else {
                    right.insert(num);
                }
            }
            if (left.size > right.size + 1) {
                int moved = left.extractMax();
                right.insert(moved);
            } else if (right.size > left.size) {
                int moved = right.extractMin();
                left.insert(moved);
            }
            count++;
        }
        public double getMedian() {
            if (left.size == right.size)
                return (left.peek() + right.peek()) / 2.0;
            else
                return left.peek();
        }
    }
    public static void main(String[] args) {
        int[] stream = {1, 3, 2, 4, 5};
        MedianFinder mf = new MedianFinder(stream.length);
        for (int i = 0; i < stream.length; i++) {
            mf.addNumber(stream[i]);
            System.out.println(mf.getMedian());
        }
    }
}

