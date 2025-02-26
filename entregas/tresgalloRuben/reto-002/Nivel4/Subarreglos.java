class Subarreglo {
    public static int[] subarregloSumaMaxima(int[] arr) {
        int maxSuma = Integer.MIN_VALUE;
        int inicio = 0, fin = 0;
        for (int i = 0; i < arr.length; i++) {
            int suma = 0;
            for (int j = i; j < arr.length; j++) {
                suma += arr[j];
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
        System.out.println("Subarreglo con suma máxima:");
        int[] resultado = subarregloSumaMaxima(arr);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
