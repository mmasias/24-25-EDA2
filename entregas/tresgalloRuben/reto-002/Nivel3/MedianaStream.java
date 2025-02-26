package Nivel3;

class MedianaStream {
    private int[] maxHeap = new int[100]; // Simulación de maxHeap
    private int[] minHeap = new int[100]; // Simulación de minHeap
    private int maxSize = 0;
    private int minSize = 0;

    public void agregarNumero(int numero) {
        if (maxSize == 0 || numero <= maxHeap[0]) {
            insertarMaxHeap(numero);
        } else {
            insertarMinHeap(numero);
        }
        balancearHeaps();
    }

    private void insertarMaxHeap(int num) {
        maxHeap[maxSize] = num;
        int i = maxSize;
        while (i > 0 && maxHeap[i] > maxHeap[(i - 1) / 2]) {
            intercambiar(maxHeap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        maxSize++;
    }

    private void insertarMinHeap(int num) {
        minHeap[minSize] = num;
        int i = minSize;
        while (i > 0 && minHeap[i] < minHeap[(i - 1) / 2]) {
            intercambiar(minHeap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        minSize++;
    }

    private void balancearHeaps() {
        if (maxSize > minSize + 1) {
            insertarMinHeap(eliminarMaxHeap());
        } else if (minSize > maxSize) {
            insertarMaxHeap(eliminarMinHeap());
        }
    }

    private int eliminarMaxHeap() {
        int raiz = maxHeap[0];
        maxHeap[0] = maxHeap[--maxSize];
        heapify(maxHeap, maxSize, 0, true);
        return raiz;
    }

    private int eliminarMinHeap() {
        int raiz = minHeap[0];
        minHeap[0] = minHeap[--minSize];
        heapify(minHeap, minSize, 0, false);
        return raiz;
    }

    private void heapify(int[] heap, int size, int i, boolean max) {
        int extremo = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;

        if (max) {
            if (izq < size && heap[izq] > heap[extremo]) extremo = izq;
            if (der < size && heap[der] > heap[extremo]) extremo = der;
        } else {
            if (izq < size && heap[izq] < heap[extremo]) extremo = izq;
            if (der < size && heap[der] < heap[extremo]) extremo = der;
        }

        if (extremo != i) {
            intercambiar(heap, i, extremo);
            heapify(heap, size, extremo, max);
        }
    }

    private void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public double obtenerMediana() {
        if (maxSize == minSize) {
            return (maxHeap[0] + minHeap[0]) / 2.0;
        } else {
            return maxHeap[0];
        }
    }

    public static void main(String[] args) {
        MedianaStream medianaStream = new MedianaStream();
        int[] numeros = {1, 3, 2, 4, 5};
        
        for (int num : numeros) {
            medianaStream.agregarNumero(num);
            System.out.println("Mediana actual: " + medianaStream.obtenerMediana());
        }
    }
}

