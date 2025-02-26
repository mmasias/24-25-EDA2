class SumaMaxima2 {
    
    private static int[] encontrarSubarregloSumaMaxima(int[] arreglo) {
        int sumaMaxima = arreglo[0];
        int sumaActual = arreglo[0];
        
        int inicioActual = 0;
        int inicioMaximo = 0;
        int finMaximo = 0;
        
        for (int i = 1; i < arreglo.length; i++) {
            if (sumaActual + arreglo[i] < arreglo[i]) {
                sumaActual = arreglo[i];
                inicioActual = i;
            } else {
                sumaActual += arreglo[i];
            }
            
            if (sumaActual > sumaMaxima) {
                sumaMaxima = sumaActual;
                inicioMaximo = inicioActual;
                finMaximo = i;
            }
        }
        
        int longitud = finMaximo - inicioMaximo + 1;
        int[] resultado = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            resultado[i] = arreglo[inicioMaximo + i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] arreglo = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int[] subarregloMaximo = encontrarSubarregloSumaMaxima(arreglo);
        
        System.out.print("Subarreglo con suma máxima: [");
        for (int i = 0; i < subarregloMaximo.length; i++) {
            System.out.print(subarregloMaximo[i]);
            if (i < subarregloMaximo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        int suma = 0;
        for (int valor : subarregloMaximo) {
            suma += valor;
        }
        System.out.println("Suma máxima: " + suma);
    }
}