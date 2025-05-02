
public class QuickSort extends AlgoritmoOrdenacion {
    @Override
    public void ordenar(String[] valores, int[][] posiciones, int[] contadores, int cantidadValores) {
        quickSort(valores, posiciones, contadores, 0, cantidadValores - 1);
    }

    private void quickSort(String[] valores, int[][] posiciones, int[] contadores, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particionar(valores, posiciones, contadores, inicio, fin);

            quickSort(valores, posiciones, contadores, inicio, indiceParticion - 1);
            quickSort(valores, posiciones, contadores, indiceParticion + 1, fin);
        }
    }

    private int particionar(String[] valores, int[][] posiciones, int[] contadores, int inicio, int fin) {

        String pivote = valores[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (comparar(valores[j], pivote) <= 0) {
                i++;
                intercambiar(valores, posiciones, contadores, i, j);
            }
        }

        intercambiar(valores, posiciones, contadores, i + 1, fin);
        return i + 1;
    }
}