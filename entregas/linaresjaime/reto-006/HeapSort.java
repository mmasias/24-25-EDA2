
public class HeapSort extends AlgoritmoOrdenacion {
    @Override
    public void ordenar(String[] valores, int[][] posiciones, int[] contadores, int cantidadValores) {

        for (int i = cantidadValores / 2 - 1; i >= 0; i--)
            heapify(valores, posiciones, contadores, cantidadValores, i);

        for (int i = cantidadValores - 1; i > 0; i--) {

            intercambiar(valores, posiciones, contadores, 0, i);

            heapify(valores, posiciones, contadores, i, 0);
        }
    }

    private void heapify(String[] valores, int[][] posiciones, int[] contadores, int n, int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;

        if (izq < n && comparar(valores[izq], valores[mayor]) > 0)
            mayor = izq;

        if (der < n && comparar(valores[der], valores[mayor]) > 0)
            mayor = der;

        if (mayor != i) {
            intercambiar(valores, posiciones, contadores, i, mayor);

            heapify(valores, posiciones, contadores, n, mayor);
        }
    }
}