public class SumaMaximaSubarreglo {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Subarreglo con suma máxima:");
        encontrarSumaMaxima(arr);
    }

    public static void encontrarSumaMaxima(int[] arr) {
        int n = arr.length;
        int maxSuma = Integer.MIN_VALUE;
        int inicio = 0, fin = 0;
        
        for (int i = 0; i < n; i++) {
            int sumaActual = 0;
            for (int j = i; j < n; j++) {
                sumaActual += arr[j];
                if (sumaActual > maxSuma) {
                    maxSuma = sumaActual;
                    inicio = i;
                    fin = j;
                }
            }
        }
        
        System.out.print("[");
        for (int k = inicio; k <= fin; k++) {
            System.out.print(arr[k] + (k < fin ? ", " : ""));
        }
        System.out.println("]");
    }
}
