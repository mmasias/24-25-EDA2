public class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        int totalElementos = 0;
        for (int i = 0; i < arrays.length; i++) {
            totalElementos += arrays[i].length;
        }
        
        int[] resultado = new int[totalElementos];
        
        int[] indices = new int[arrays.length];
        
        for (int i = 0; i < totalElementos; i++) {
            int minValor = Integer.MAX_VALUE;
            int minIndiceArray = -1;
            
            for (int j = 0; j < arrays.length; j++) {
                if (indices[j] < arrays[j].length && 
                    (minIndiceArray == -1 || arrays[j][indices[j]] < minValor)) {
                    minValor = arrays[j][indices[j]];
                    minIndiceArray = j;
                }
            }
            
            resultado[i] = minValor;
            indices[minIndiceArray]++;
        }
        
        return resultado;
    }
    
    public static int[] combinarArraysOptimizado(int[][] arrays) {
        int totalElementos = 0;
        for (int i = 0; i < arrays.length; i++) {
            totalElementos += arrays[i].length;
        }
        
        int[] resultado = new int[totalElementos];
        
        MinHeap heap = new MinHeap(arrays.length);
        
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                heap.insertar(new Elemento(arrays[i][0], i, 0));
            }
        }
        
        int indiceResultado = 0;
        while (!heap.estaVacio()) {
            Elemento minElemento = heap.extraerMin();
            
            resultado[indiceResultado++] = minElemento.valor;
            
            int arrayIndice = minElemento.arrayIndice;
            int elementoIndice = minElemento.elementoIndice + 1;
            
            if (elementoIndice < arrays[arrayIndice].length) {
                heap.insertar(new Elemento(
                    arrays[arrayIndice][elementoIndice], 
                    arrayIndice, 
                    elementoIndice
                ));
            }
        }
        
        return resultado;
    }
    
    static class Elemento {
        int valor;
        int arrayIndice;
        int elementoIndice;
        
        Elemento(int valor, int arrayIndice, int elementoIndice) {
            this.valor = valor;
            this.arrayIndice = arrayIndice;
            this.elementoIndice = elementoIndice;
        }
    }
    
    static class MinHeap {
        Elemento[] heap;
        int tamaño;
        int capacidad;
        
        MinHeap(int capacidad) {
            this.capacidad = capacidad;
            this.tamaño = 0;
            this.heap = new Elemento[capacidad];
        }
        
        boolean estaVacio() {
            return tamaño == 0;
        }
        
        void insertar(Elemento elemento) {
            if (tamaño == capacidad) {
                return;
            }
            
            tamaño++;
            int i = tamaño - 1;
            heap[i] = elemento;
            
            while (i != 0 && heap[padre(i)].valor > heap[i].valor) {
                intercambiar(i, padre(i));
                i = padre(i);
            }
        }
        
        Elemento extraerMin() {
            if (tamaño <= 0) {
                return null;
            }
            
            if (tamaño == 1) {
                tamaño--;
                return heap[0];
            }
            
            Elemento raiz = heap[0];
            heap[0] = heap[tamaño - 1];
            tamaño--;
            heapify(0);
            
            return raiz;
        }
        
        void heapify(int i) {
            int izq = izquierdo(i);
            int der = derecho(i);
            int menor = i;
            
            if (izq < tamaño && heap[izq].valor < heap[i].valor) {
                menor = izq;
            }
            
            if (der < tamaño && heap[der].valor < heap[menor].valor) {
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
            Elemento temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int[] resultado = combinarArraysOptimizado(arrays);
        
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }
}
