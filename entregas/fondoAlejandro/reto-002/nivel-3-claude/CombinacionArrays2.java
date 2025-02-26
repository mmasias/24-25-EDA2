class CombinacionArrays2 {
    public static int[] combinarArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        
        int longitudTotal = 0;
        for (int i = 0; i < arrays.length; i++) {
            longitudTotal += arrays[i].length;
        }
        
        int[] resultado = new int[longitudTotal];
        
        int[] indices = new int[arrays.length];
        
        for (int i = 0; i < longitudTotal; i++) {
            int minValor = Integer.MAX_VALUE;
            int minIndice = -1;
            
            for (int j = 0; j < arrays.length; j++) {
                if (indices[j] < arrays[j].length && arrays[j][indices[j]] < minValor) {
                    minValor = arrays[j][indices[j]];
                    minIndice = j;
                }
            }
            
            resultado[i] = minValor;
            indices[minIndice]++;
        }
        
        return resultado;
    }
    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        int[] resultado = combinarArrays(arrays);
        
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}