import java.util.Arrays;

public class SumaMaxima {
    public static int[] encontrarSubarregloMaximo(int[] array) {
        int maxSuma = array[0];
        int sumaActual = array[0];
        int inicio = 0;
        int fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < array.length; i++) {
            if (sumaActual + array[i] > array[i]) {
                sumaActual += array[i];
            } else {
                sumaActual = array[i];
                tempInicio = i;
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        int[] subarreglo = new int[fin - inicio + 1];
        System.arraycopy(array, inicio, subarreglo, 0, subarreglo.length);
        return subarreglo;
    }

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarreglo = encontrarSubarregloMaximo(array);
        System.out.println("Subarreglo con suma máxima: " + Arrays.toString(subarreglo));
    }
}
