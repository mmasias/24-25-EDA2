public class MedianaStream {
    static class MaxHeap {
        int[] heap;
        int tamaño;
        int capacidad;
        
        MaxHeap(int capacidad) {
            this.capacidad = capacidad;
            this.tamaño = 0;
            this.heap = new int[capacidad];
        }
        
        boolean estaVacio() {
            return tamaño == 0;
        }
        
        int tamaño() {
            return tamaño;
        }
        
        int peek() {
            if (tamaño == 0) {
                return -1;
            }
            return heap[0];
        }
        
        void insertar(int valor) {
            if (tamaño == capacidad) {
                return;
            }
            
            tamaño++;
            int i = tamaño - 1;
            heap[i] = valor;
            
            while (i != 0 && heap[padre(i)] < heap[i]) {
                intercambiar(i, padre(i));
                i = padre(i);
            }
        }
        
        int extraerMax() {
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
            int mayor = i;
            
            if (izq < tamaño && heap[izq] > heap[i]) {
                mayor = izq;
            }
            
            if (der < tamaño && heap[der] > heap[mayor]) {
                mayor = der;
            }
            
            if (mayor != i) {
                intercambiar(i, mayor);
                heapify(mayor);
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
        
        int tamaño() {
            return tamaño;
        }
        
        int peek() {
            if (tamaño == 0) {
                return -1;
            }
            return heap[0];
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
    
    static class MedianFinder {
        MaxHeap menores;
        MinHeap mayores;
        
        MedianFinder(int capacidad) {
            menores = new MaxHeap(capacidad);
            mayores = new MinHeap(capacidad);
        }
        
        void addNum(int num) {
            if (menores.estaVacio() || num <= menores.peek()) {
                menores.insertar(num);
            } else {
                mayores.insertar(num);
            }
            
            rebalancear();
        }
        
        void rebalancear() {
            if (menores.tamaño() > mayores.tamaño() + 1) {
                mayores.insertar(menores.extraerMax());
            } else if (mayores.tamaño() > menores.tamaño()) {
                menores.insertar(mayores.extraerMin());
            }
        }
        
        double findMedian() {
            if (menores.tamaño() == mayores.tamaño()) {
                return (menores.peek() + mayores.peek()) / 2.0;
            } else {
                return menores.peek();
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5};
        MedianFinder mf = new MedianFinder(nums.length);
        
        for (int num : nums) {
            mf.addNum(num);
            System.out.println("Después de añadir " + num + ", la mediana es: " + mf.findMedian());
        }
    }
}
