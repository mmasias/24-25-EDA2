package EjerciciosAlgoritmos;

public class KElementos {

    public static int[] encontrarKElementosMasCercanos(int[] array, int k, double target) {
        int arrayTamano = array.length;
        int[] resultado = new int[k];
        double[] distancias = new double[arrayTamano];

        for (int indice = 0; indice < arrayTamano; indice++) {
            distancias[indice] = Math.abs(array[indice] - target);
        }

        for (int indice = 0; indice < k; indice++) {
            int minIndice = -1;
            double minDistancia = Double.MAX_VALUE;

            for (int indiceDistancia = 0; indiceDistancia < arrayTamano; indiceDistancia++) {
                if (distancias[indiceDistancia] < minDistancia) {
                    minDistancia = distancias[indiceDistancia];
                    minIndice = indiceDistancia;
                }
            }

            resultado[indice] = array[minIndice];
            distancias[minIndice] = Double.MAX_VALUE;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arrayay = { 1, 2, 3, 4, 5 };
        int k = 2;
        double target = 3.7;
        int[] resultado = encontrarKElementosMasCercanos(arrayay, k, target);

        System.out.print("Los " + k + " elementos más cercanos a " + target + " son: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}