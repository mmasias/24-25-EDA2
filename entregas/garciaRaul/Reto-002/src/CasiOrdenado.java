public class CasiOrdenado {
    
    public static void ordenarInsercion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valor = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > valor) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = valor;
        }
    }
    
    public static void ordenarConK(int[] array, int k) {
        for (int i = 1; i < array.length; i++) {
            int valor = array[i];
            int j = Math.max(0, i - k);
            
            while (j < i && array[j] <= valor) {
                j++;
            }
            
            if (j < i) {
                System.arraycopy(array, j, array, j + 1, i - j);
                array[j] = valor;
            }
        }
    }
    
    public static void ordenarHeapK(int[] array, int k) {
        int n = array.length;
        
        if (k >= n) {
            ordenarHeap(array);
            return;
        }
        
        int[] heap = new int[k + 1];
        
        for (int i = 0; i <= k && i < n; i++) {
            heap[i] = array[i];
        }
        
        construirHeapMin(heap, k + 1);
        
        for (int i = 0; i < n; i++) {
            if (i + k + 1 < n) {
                array[i] = heap[0];
                heap[0] = array[i + k + 1];
                ajustarHeapMin(heap, 0, k + 1);
            } else {
                array[i] = heap[0];
                heap[0] = heap[k--];
                ajustarHeapMin(heap, 0, k + 1);
            }
        }
    }
    
    private static void ordenarHeap(int[] array) {
        int n = array.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustarHeap(array, i, n);
        }
        
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            ajustarHeap(array, 0, i);
        }
    }
    
    private static void ajustarHeap(int[] array, int raiz, int n) {
        int mayor = raiz;
        int izquierda = 2 * raiz + 1;
        int derecha = 2 * raiz + 2;
        
        if (izquierda < n && array[izquierda] > array[mayor]) {
            mayor = izquierda;
        }
        
        if (derecha < n && array[derecha] > array[mayor]) {
            mayor = derecha;
        }
        
        if (mayor != raiz) {
            int temp = array[raiz];
            array[raiz] = array[mayor];
            array[mayor] = temp;
            
            ajustarHeap(array, mayor, n);
        }
    }
    
    private static void construirHeapMin(int[] heap, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustarHeapMin(heap, i, n);
        }
    }
    
    private static void ajustarHeapMin(int[] heap, int raiz, int n) {
        int menor = raiz;
        int izquierda = 2 * raiz + 1;
        int derecha = 2 * raiz + 2;
        
        if (izquierda < n && heap[izquierda] < heap[menor]) {
            menor = izquierda;
        }
        
        if (derecha < n && heap[derecha] < heap[menor]) {
            menor = derecha;
        }
        
        if (menor != raiz) {
            int temp = heap[raiz];
            heap[raiz] = heap[menor];
            heap[menor] = temp;
            
            ajustarHeapMin(heap, menor, n);
        }
    }
    
    public static void main(String[] args) {
        int[] array1 = {2, 1, 3, 5, 4};
        int k = 2;
        
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();
        
        ordenarInsercion(array1);
        System.out.print("Ordenamiento por inserción: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        ordenarConK(array2, k);
        System.out.print("Ordenamiento con K: ");
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        ordenarHeapK(array3, k);
        System.out.print("Ordenamiento con Heap K: ");
        for (int num : array3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}