public class CasiOrdenado {
    public static int[] ordenarK(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int[] resultado = new int[arr.length];
        
        MinHeap heap = new MinHeap(k + 1);
        
        int i = 0;
        for (; i < Math.min(k + 1, arr.length); i++) {
            heap.insertar(arr[i]);
        }
        
        int indiceResultado = 0;
        
        while (!heap.estaVacio()) {
            resultado[indiceResultado++] = heap.extraerMin();
            
            if (i < arr.length) {
                heap.insertar(arr[i++]);
            }
        }
        
        return resultado;
    }
    
    static class MinHeap {
        int[] heap;
        int tamaño;
        int capacidad;
        
        MinHeap(int capacidad) {
            this.capacidad = capacidad;
            this.tamaño = 0;
            this.heap = new int[capacidad];
        }
        
        boolean estaVacio() {
            return tamaño == 0;
        }
        
        void insertar(int valor) {
            if (tamaño == capacidad) {
                return;
            }
            
            tamaño++;
            int i = tamaño - 1;
            heap[i] = valor;
            
            while (i != 0 && heap[padre(i)] > heap[i]) {
                intercambiar(i, padre(i));
                i = padre(i);
            }
        }
        
        int extraerMin() {
            if (tamaño <= 0) {
                return -1;
            }
            
            if (tamaño == 1) {
                tamaño--;
                return heap[0];
            }
            
            int raiz = heap[0];
            heap[0] = heap[tamaño - 1];
            tamaño--;
            heapify(0);
            
            return raiz;
        }
        
        void heapify(int i) {
            int izq = izquierdo(i);
            int der = derecho(i);
            int menor = i;
            
            if (izq < tamaño && heap[izq] < heap[i]) {
                menor = izq;
            }
            
            if (der < tamaño && heap[der] < heap[menor]) {
                menor = der;
            }
            
            if (menor != i) {
                intercambiar(i, menor);
                heapify(menor);
            }
        }
        
        int padre(int i) {
            return (i - 1) / 2;
        }
        
        int izquierdo(int i) {
            return 2 * i + 1;
        }
        
        int derecho(int i) {
            return 2 * i + 2;
        }
        
        void intercambiar(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        int k = 2;
        
        int[] resultado = ordenarK(arr, k);
        
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }
}
