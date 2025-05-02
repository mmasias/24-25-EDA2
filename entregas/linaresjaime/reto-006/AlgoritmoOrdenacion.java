
public abstract class AlgoritmoOrdenacion {

    public abstract void ordenar(String[] valores, int[][] posiciones, int[] contadores, int cantidadValores);

    protected void intercambiar(String[] valores, int[][] posiciones, int[] contadores, int i, int j) {

        String tempValor = valores[i];
        valores[i] = valores[j];
        valores[j] = tempValor;

        int[] tempPosiciones = posiciones[i];
        posiciones[i] = posiciones[j];
        posiciones[j] = tempPosiciones;

        int tempContador = contadores[i];
        contadores[i] = contadores[j];
        contadores[j] = tempContador;
    }

    protected int comparar(String valor1, String valor2) {
        return valor1.compareTo(valor2);
    }
}