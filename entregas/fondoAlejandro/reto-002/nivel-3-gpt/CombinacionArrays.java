class CombinacionArrays {
    public static int[] combinarArraysOrdenados(int[][] arrays) {
        int totalElementos = 0;
        for (int[] array : arrays) {
            totalElementos += array.length;
        }
        
        int[] resultado = new int[totalElementos];
        int[] indices = new int[arrays.length];
        int index = 0;
        
        while (index < totalElementos) {
            int minValor = Integer.MAX_VALUE;
            int minIndice = -1;
            
            for (int i = 0; i < arrays.length; i++) {
                if (indices[i] < arrays[i].length && arrays[i][indices[i]] < minValor) {
                    minValor = arrays[i][indices[i]];
                    minIndice = i;
                }
            }
            
            resultado[index++] = minValor;
            indices[minIndice]++;
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int[] resultado = combinarArraysOrdenados(arrays);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
