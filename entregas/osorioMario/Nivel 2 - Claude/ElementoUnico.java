public class ElementoUnico {
    public static int encontrarElementoUnico(int[] numeros) {
        int MAX_VALOR = 1000; 
        int[] frecuencia = new int[MAX_VALOR + 1];
        
        for (int i = 0; i < numeros.length; i++) {
            frecuencia[numeros[i]]++;
        }
        
        for (int i = 0; i <= MAX_VALOR; i++) {
            if (frecuencia[i] == 1) {
                return i;
            }
        }
        
        return -1; 
    }
    
    public static int encontrarElementoUnicoXOR(int[] numeros) {
        int resultado = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            resultado ^= numeros[i];
        }
        
        return resultado;
    }
    
    public static int encontrarElementoUnicoOrdenamiento(int[] numeros) {
        quickSort(numeros, 0, numeros.length - 1);
        
        for (int i = 0; i < numeros.length; i += 2) {
            if (i == numeros.length - 1 || numeros[i] != numeros[i + 1]) {
                return numeros[i];
            }
        }
        
        return -1; 
    }
    
    private static void quickSort(int[] numeros, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = partition(numeros, inicio, fin);
            quickSort(numeros, inicio, pivotIndex - 1);
            quickSort(numeros, pivotIndex + 1, fin);
        }
    }
    
    private static int partition(int[] numeros, int inicio, int fin) {
        int pivot = numeros[fin];
        int i = inicio - 1;
        
        for (int j = inicio; j < fin; j++) {
            if (numeros[j] <= pivot) {
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }
        
        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[fin];
        numeros[fin] = temp;
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};
        
        int unico1 = encontrarElementoUnico(numeros);
        int unico2 = encontrarElementoUnicoXOR(numeros);
        int unico3 = encontrarElementoUnicoOrdenamiento(numeros.clone()); 
        
        System.out.println("Elemento único (conteo): " + unico1);
        System.out.println("Elemento único (XOR): " + unico2);
        System.out.println("Elemento único (ordenamiento): " + unico3);
    }
}
