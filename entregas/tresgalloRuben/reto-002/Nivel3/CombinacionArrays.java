package Nivel3;

class CombinacionArrays {
    public static int[] combinarArrays(int[][] arrays) {
        int totalElementos = 0;
        for (int[] array : arrays) {
            totalElementos += array.length;
        }
        
        int[] resultado = new int[totalElementos];
        int[] indices = new int[arrays.length]; 
        
        for (int i = 0; i < totalElementos; i++) {
            int minValor = Integer.MAX_VALUE;
            int minArray = -1;
            
            for (int j = 0; j < arrays.length; j++) {
                if (indices[j] < arrays[j].length && arrays[j][indices[j]] < minValor) {
                    minValor = arrays[j][indices[j]];
                    minArray = j;
                }
            }
            
            resultado[i] = minValor;
            indices[minArray]++;
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
