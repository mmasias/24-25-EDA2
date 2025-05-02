
public class MergeSort extends AlgoritmoOrdenacion {
    @Override
    public void ordenar(String[] valores, int[][] posiciones, int[] contadores, int cantidadValores) {

        String[] auxValores = new String[cantidadValores];
        int[][] auxPosiciones = new int[cantidadValores][];
        int[] auxContadores = new int[cantidadValores];

        mergeSort(valores, posiciones, contadores, auxValores, auxPosiciones, auxContadores, 0, cantidadValores - 1);
    }

    private void mergeSort(String[] valores, int[][] posiciones, int[] contadores,
            String[] auxValores, int[][] auxPosiciones, int[] auxContadores,
            int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            mergeSort(valores, posiciones, contadores, auxValores, auxPosiciones, auxContadores, inicio, medio);
            mergeSort(valores, posiciones, contadores, auxValores, auxPosiciones, auxContadores, medio + 1, fin);

            merge(valores, posiciones, contadores, auxValores, auxPosiciones, auxContadores, inicio, medio, fin);
        }
    }

    private void merge(String[] valores, int[][] posiciones, int[] contadores,
            String[] auxValores, int[][] auxPosiciones, int[] auxContadores,
            int inicio, int medio, int fin) {

        for (int i = inicio; i <= fin; i++) {
            auxValores[i] = valores[i];
            auxPosiciones[i] = posiciones[i];
            auxContadores[i] = contadores[i];
        }

        int i = inicio;
        int j = medio + 1;
        int k = inicio;

        while (i <= medio && j <= fin) {
            if (comparar(auxValores[i], auxValores[j]) <= 0) {
                valores[k] = auxValores[i];
                posiciones[k] = auxPosiciones[i];
                contadores[k] = auxContadores[i];
                i++;
            } else {
                valores[k] = auxValores[j];
                posiciones[k] = auxPosiciones[j];
                contadores[k] = auxContadores[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            valores[k] = auxValores[i];
            posiciones[k] = auxPosiciones[i];
            contadores[k] = auxContadores[i];
            i++;
            k++;
        }
    }
}