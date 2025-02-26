class SumaMaxima {
    public static int[] encontrarSubarregloMaximo(int[] numeros) {
        int tamano = numeros.length;
        int sumaMaxima = numeros[0];
        int sumaActual = numeros[0];
        int inicio = 0, fin = 0, inicioTemporal = 0;

        for (int i = 1; i < tamano; i++) {
            if (sumaActual < 0) {
                sumaActual = numeros[i];
                inicioTemporal = i;
            } else {
                sumaActual += numeros[i];
            }

            if (sumaActual > sumaMaxima) {
                sumaMaxima = sumaActual;
                inicio = inicioTemporal;
                fin = i;
            }
        }

        int[] subarregloMaximo = new int[fin - inicio + 1];
        for (int i = inicio; i <= fin; i++) {
            subarregloMaximo[i - inicio] = numeros[i];
        }
        return subarregloMaximo;
    }

    public static void main(String[] args) {
        int[] numeros = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarSubarregloMaximo(numeros);
        
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
