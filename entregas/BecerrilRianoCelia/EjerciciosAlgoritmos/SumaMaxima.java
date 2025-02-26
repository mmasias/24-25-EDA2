package EjerciciosAlgoritmos;

public class SumaMaxima {

    public static int[] encontrarsubarraySumaMaxima(int[] numeros) {
        int sumaMaximaActual = numeros[0];
        int sumaMaximaGlobal = numeros[0];
        int inicio = 0, fin = 0, inicioTemporal = 0;

        for (int indice = 1; indice < numeros.length; indice++) {
            if (numeros[indice] > sumaMaximaActual + numeros[indice]) {
                sumaMaximaActual = numeros[indice];
                inicioTemporal = indice;
            } else {
                sumaMaximaActual += numeros[indice];
            }

            if (sumaMaximaActual > sumaMaximaGlobal) {
                sumaMaximaGlobal = sumaMaximaActual;
                inicio = inicioTemporal;
                fin = indice;
            }
        }

        int[] subarrayMaximo = new int[fin - inicio + 1];
        for (int indice = inicio; indice <= fin; indice++) {
            subarrayMaximo[indice - inicio] = numeros[indice];
        }

        return subarrayMaximo;
    }

    public static void main(String[] args) {
        int[] numeros = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarsubarraySumaMaxima(numeros);

        System.out.print("subarray con suma máxima: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}