import java.util.*;

public class SumaMaxima {
    public static int[] subarraySumaMaxima(int[] arr) {
        int maxSuma = arr[0], sumaActual = arr[0];
        int inicio = 0, fin = 0, tempInicio = 0;

        for (int i = 1; i < arr.length; i++) {
            if (sumaActual + arr[i] > arr[i]) {
                sumaActual += arr[i];
            } else {
                sumaActual = arr[i];
                tempInicio = i;
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        return Arrays.copyOfRange(arr, inicio, fin + 1);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(subarraySumaMaxima(arr)));
    }
}
