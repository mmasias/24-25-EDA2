class CasiOrdenado2 {
    public static int[] ordenarArrayCasiOrdenado(int[] array, int k) {
        if (array == null || array.length <= 1) {
            return array;
        }
        
        int longitud = array.length;
        int[] resultado = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            int minIndex = i;
            int limite = Math.min(i + k, longitud - 1);
            
            for (int j = i + 1; j <= limite; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            resultado[i] = array[minIndex];
            
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4};
        int k = 2;
        
        int[] arrayOrdenado = ordenarArrayCasiOrdenado(array, k);
        
        for (int valor : arrayOrdenado) {
            System.out.print(valor + " ");
        }
    }
}