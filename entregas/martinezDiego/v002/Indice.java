package v002;

public class Indice {
    private String[] valores;
    private int[][] posiciones;
    private int[] contadores;
    private int cantidadValores;

    public Indice(int capacidadMaxima) {
        valores = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima][capacidadMaxima];
        contadores = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    public void agregar(String valor, int posicion) {
        int indiceValor = -1;
        int i = 0;

        while (i < cantidadValores && indiceValor == -1) {
            if (valores[i].equals(valor)) {
                indiceValor = i;
            }
            i++;
        }

        if (indiceValor == -1) {
            valores[cantidadValores] = valor;
            indiceValor = cantidadValores;
            cantidadValores++;
        }

        posiciones[indiceValor][contadores[indiceValor]] = posicion;
        contadores[indiceValor]++;
    }

    public int[] buscar(String valor) {
        int indiceValor = -1;
        int posicion = 0;

        while (posicion < cantidadValores && indiceValor == -1) {
            if (valores[posicion].equals(valor)) {
                indiceValor = posicion;
            }
            posicion++;
        }

        if (indiceValor == -1) {
            return new int[0];
        }

        int[] resultado = new int[contadores[indiceValor]];
        for (int i = 0; i < contadores[indiceValor]; i++) {
            resultado[i] = posiciones[indiceValor][i];
        }

        return resultado;
    }

    public boolean contiene(String valor) {
        for (int i = 0; i < cantidadValores; i++) {
            if (valores[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public String[] obtenerTodos() {
        String[] resultado = new String[cantidadValores];
        for (int i = 0; i < cantidadValores; i++) {
            resultado[i] = valores[i];
        }
        return resultado;
    }

    public void ordenar() {
        if (cantidadValores > 1) {
            mergeSort(0, cantidadValores - 1);
        }
    }

    private void mergeSort(int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(inicio, medio);
            mergeSort(medio + 1, fin);
            merge(inicio, medio, fin);
        }
    }

    private void merge(int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        String[] izquierda = new String[n1];
        String[] derecha = new String[n2];
        int[][] posicionesIzquierda = new int[n1][];
        int[][] posicionesDerecha = new int[n2][];
        int[] contadoresIzquierda = new int[n1];
        int[] contadoresDerecha = new int[n2];

        for (int i = 0; i < n1; i++) {
            izquierda[i] = valores[inicio + i];
            posicionesIzquierda[i] = posiciones[inicio + i];
            contadoresIzquierda[i] = contadores[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha[j] = valores[medio + 1 + j];
            posicionesDerecha[j] = posiciones[medio + 1 + j];
            contadoresDerecha[j] = contadores[medio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                valores[k] = izquierda[i];
                posiciones[k] = posicionesIzquierda[i];
                contadores[k] = contadoresIzquierda[i];
                i++;
            } else {
                valores[k] = derecha[j];
                posiciones[k] = posicionesDerecha[j];
                contadores[k] = contadoresDerecha[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            valores[k] = izquierda[i];
            posiciones[k] = posicionesIzquierda[i];
            contadores[k] = contadoresIzquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            valores[k] = derecha[j];
            posiciones[k] = posicionesDerecha[j];
            contadores[k] = contadoresDerecha[j];
            j++;
            k++;
        }
    }
}
