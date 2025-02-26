public class SumaMaxima {
    public static int[] encontrar(int[] arr) {
        int maxSuma = Integer.MIN_VALUE;
        int inicio = 0, fin = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int suma = 0;
                for (int k = i; k <= j; k++) {
                    suma += arr[k];
                }
                if (suma > maxSuma) {
                    maxSuma = suma;
                    inicio = i;
                    fin = j;
                }
            }
        }
        int[] resultado = new int[fin - inicio + 1];
        System.arraycopy(arr, inicio, resultado, 0, fin - inicio + 1);
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrar(arr);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}