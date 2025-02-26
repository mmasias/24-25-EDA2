public class SumaMaxima {
    public static int[] encontrarSubarregloMaximo(int[] numeros) {
        int maxSuma = numeros[0];
        int sumaActual = numeros[0];
        int inicio = 0, fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > sumaActual + numeros[i]) {
                sumaActual = numeros[i];
                tempInicio = i;
            } else {
                sumaActual += numeros[i];
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        int[] resultado = new int[fin - inicio + 1];
        System.arraycopy(numeros, inicio, resultado, 0, resultado.length);
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarreglo = encontrarSubarregloMaximo(numeros);
        System.out.print("Subarreglo con suma máxima: ");
        for (int num : subarreglo) {
            System.out.print(num + " ");
        }
    }
}