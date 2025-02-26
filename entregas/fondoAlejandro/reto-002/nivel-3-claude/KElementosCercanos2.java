class KElementosCercanos2 {
    public static int[] encontrarKElementosMasCercanos(int[] numeros, int k, double target) {
        if (numeros == null || numeros.length == 0 || k <= 0) {
            return new int[0];
        }
        
        if (k > numeros.length) {
            k = numeros.length;
        }
        
        double[] distancias = new double[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            distancias[i] = Math.abs(numeros[i] - target);
        }
        
        int[] resultado = new int[k];
        
        for (int i = 0; i < k; i++) {
            int indiceMinimo = encontrarIndiceMinimo(distancias);
            resultado[i] = numeros[indiceMinimo];
            distancias[indiceMinimo] = Double.MAX_VALUE;
        }
        
        ordenarArray(resultado);
        
        return resultado;
    }
    
    private static int encontrarIndiceMinimo(double[] array) {
        int indiceMinimo = 0;
        double valorMinimo = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < valorMinimo) {
                valorMinimo = array[i];
                indiceMinimo = i;
            }
        }
        
        return indiceMinimo;
    }
    
    private static void ordenarArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valorActual = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > valorActual) {
                array[j + 1] = array[j];
                j--;
            }
            
            array[j + 1] = valorActual;
        }
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        
        int[] resultado = encontrarKElementosMasCercanos(numeros, k, target);
        
        for (int numero : resultado) {
            System.out.print(numero + " ");
        }
    }
}