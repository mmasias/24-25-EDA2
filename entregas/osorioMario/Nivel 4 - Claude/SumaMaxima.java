public class SumaMaxima {
    public static int[] encontrarSubarregloSumaMaxima(int[] numeros) {
        // Encontrar los índices del subarreglo con suma máxima
        int maxSuma = numeros[0];
        int sumaActual = numeros[0];
        int inicioTemp = 0;
        int inicio = 0;
        int fin = 0;
        
        for (int i = 1; i < numeros.length; i++) {
            // Si la suma actual es negativa, mejor empezar de nuevo
            if (sumaActual < 0) {
                sumaActual = numeros[i];
                inicioTemp = i;
            } else {
                sumaActual += numeros[i];
            }
            
            // Si encontramos una suma mayor, actualizamos los índices
            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = inicioTemp;
                fin = i;
            }
        }
        
        // Crear y llenar el subarreglo resultado
        int longitud = fin - inicio + 1;
        int[] resultado = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            resultado[i] = numeros[inicio + i];
        }
        
        return resultado;
    }
    
    // Una implementación alternativa usando el algoritmo de Kadane
    public static int[] kadane(int[] numeros) {
        int maxGlobal = numeros[0];
        int maxActual = numeros[0];
        int inicio = 0;
        int fin = 0;
        int inicioTemp = 0;
        
        for (int i = 1; i < numeros.length; i++) {
            // Decidir si empezar un nuevo subarreglo o extender el existente
            if (numeros[i] > maxActual + numeros[i]) {
                maxActual = numeros[i];
                inicioTemp = i;
            } else {
                maxActual = maxActual + numeros[i];
            }
            
            // Actualizar el máximo global si es necesario
            if (maxActual > maxGlobal) {
                maxGlobal = maxActual;
                inicio = inicioTemp;
                fin = i;
            }
        }
        
        // Crear y llenar el subarreglo resultado
        int longitud = fin - inicio + 1;
        int[] resultado = new int[longitud];
        
        for (int i = 0; i < longitud; i++) {
            resultado[i] = numeros[inicio + i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] entrada = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int[] resultado = encontrarSubarregloSumaMaxima(entrada);
        
        System.out.print("Subarreglo con suma máxima: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Verificar con el algoritmo de Kadane
        int[] resultadoKadane = kadane(entrada);
        
        System.out.print("Usando Kadane: [");
        for (int i = 0; i < resultadoKadane.length; i++) {
            System.out.print(resultadoKadane[i]);
            if (i < resultadoKadane.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
