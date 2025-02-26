public class CombinacionArrays {
    
    public static int[] combinarDosArrays(int[] array1, int[] array2) {
        int[] resultado = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                resultado[k++] = array1[i++];
            } else {
                resultado[k++] = array2[j++];
            }
        }
        
        while (i < array1.length) {
            resultado[k++] = array1[i++];
        }
        
        while (j < array2.length) {
            resultado[k++] = array2[j++];
        }
        
        return resultado;
    }
    
    public static int[] combinarKArrays(int[][] arrays) {
        if (arrays.length == 0) {
            return new int[0];
        }
        
        int totalLength = 0;
        for (int[] array : arrays) {
            totalLength += array.length;
        }
        
        int[] resultado = new int[totalLength];
        int[] indices = new int[arrays.length];
        
        for (int k = 0; k < totalLength; k++) {
            int menorValor = Integer.MAX_VALUE;
            int menorIndice = -1;
            
            for (int i = 0; i < arrays.length; i++) {
                if (indices[i] < arrays[i].length && 
                    (menorIndice == -1 || arrays[i][indices[i]] < menorValor)) {
                    menorValor = arrays[i][indices[i]];
                    menorIndice = i;
                }
            }
            
            resultado[k] = menorValor;
            indices[menorIndice]++;
        }
        
        return resultado;
    }
    
    public static int[] combinarKArraysDividirConquistar(int[][] arrays) {
        if (arrays.length == 0) {
            return new int[0];
        }
        
        return dividirConquistar(arrays, 0, arrays.length - 1);
    }
    
    private static int[] dividirConquistar(int[][] arrays, int inicio, int fin) {
        if (inicio == fin) {
            return arrays[inicio];
        }
        
        int medio = inicio + (fin - inicio) / 2;
        int[] izquierda = dividirConquistar(arrays, inicio, medio);
        int[] derecha = dividirConquistar(arrays, medio + 1, fin);
        
        return combinarDosArrays(izquierda, derecha);
    }
    
    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        int[] resultadoSimple = combinarKArrays(arrays);
        System.out.print("Combinación simple: ");
        for (int num : resultadoSimple) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] resultadoDyC = combinarKArraysDividirConquistar(arrays);
        System.out.print("Combinación divide y conquista: ");
        for (int num : resultadoDyC) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}