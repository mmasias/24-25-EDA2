package entregas.lopezMartin.reto002.src;

public class SumaMaxima {
    
    public static int[] encontrarSubarregloMaximo1(int[] arr) {
        int n = arr.length;
        int sumaMaxima = arr[0];  
        int sumaActual = arr[0];  
        int inicio = 0, fin = 0, tempInicio = 0;  

        for (int i = 1; i < n; i++) {
            
            if (sumaActual < 0) {
                sumaActual = arr[i];
                tempInicio = i;
            } else {
                sumaActual += arr[i];
            }

            if (sumaActual > sumaMaxima) {
                sumaMaxima = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        int[] resultado = new int[fin - inicio + 1];
        for (int i = inicio; i <= fin; i++) {
            resultado[i - inicio] = arr[i];
        }

        return resultado;
    }

    public static int[] encontrarSubarregloMaximo2(int[] arr) {
        int n = arr.length;
        int sumaMaxima = Integer.MIN_VALUE; 
        int[] resultado = new int[0]; 

        for (int i = 0; i < n; i++) { 
            int sumaActual = 0; 
            for (int j = i; j < n; j++) { 
                sumaActual += arr[j];

                if (sumaActual > sumaMaxima) {
                    sumaMaxima = sumaActual;
                    resultado = new int[j - i + 1]; 
                    for (int k = i; k <= j; k++) {
                        resultado[k - i] = arr[k]; 
                    }
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarSubarregloMaximo2(arr);

        System.out.print("Subarreglo con suma máxima: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
