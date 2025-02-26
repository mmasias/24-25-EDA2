public class SumaMaxima {
    
    public static int[] encontrarSubarrayMaximo(int[] arr) {
        int n = arr.length;
        int sumaMaxima = arr[0];
        int sumaActual = arr[0];
        
        int inicioActual = 0;
        int inicioMaximo = 0;
        int finMaximo = 0;
        
        for (int i = 1; i < n; i++) {
            if (sumaActual + arr[i] > arr[i]) {
                sumaActual += arr[i];
            } else {
                sumaActual = arr[i];
                inicioActual = i;
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
            resultado[i] = arr[inicioMaximo + i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarrayMaximo = encontrarSubarrayMaximo(arr);
        
        System.out.println("Subarray con suma máxima:");
        for (int num : subarrayMaximo) {
            System.out.print(num + " ");
        }
        
        int suma = 0;
        for (int num : subarrayMaximo) {
            suma += num;
        }
        System.out.println("\nSuma máxima: " + suma);
    }
}