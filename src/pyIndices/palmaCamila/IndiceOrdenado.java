package palmaCamila;

import java.util.ArrayList;
import java.util.List;

public class IndiceOrdenado {
    private String[] claves;
    private int[] posiciones;
    private int cantidadValores;

    public IndiceOrdenado(int capacidadMaxima) {
        claves = new String[capacidadMaxima];
        posiciones = new int[capacidadMaxima];
        cantidadValores = 0;
    }

    public void agregar(String valor, int posicion) {
        if (cantidadValores >= claves.length) {
            throw new IllegalStateException("Capacidad máxima alcanzada");
        }
        claves[cantidadValores] = valor;
        posiciones[cantidadValores] = posicion;
        cantidadValores++;
        sort(claves, posiciones, 0, cantidadValores - 1);
    }

    public int[] buscar(String valor) {
        int idx = binarySearch(valor, 0, cantidadValores - 1);
        if (idx == -1) {
            return new int[0];
        }

        int inicio = idx;
        while (inicio > 0 && claves[inicio - 1].equals(valor)) {
            inicio--;
        }
        int fin = idx;
        while (fin < cantidadValores - 1 && claves[fin + 1].equals(valor)) {
            fin++;
        }
        int[] resultado = new int[fin - inicio + 1];
        for (int i = inicio; i <= fin; i++) {
            resultado[i - inicio] = posiciones[i];
        }
        return resultado;
    }

    public boolean contiene(String valor) {
        return binarySearch(valor, 0, cantidadValores - 1) != -1;
    }

    public String[] obtenerTodos() {
        if (cantidadValores == 0) {
            return new String[0];
        }
        List<String> unicos = new ArrayList<>();
        String anterior = null;
        for (int i = 0; i < cantidadValores; i++) {
            if (i == 0 || !claves[i].equals(anterior)) {
                unicos.add(claves[i]);
                anterior = claves[i];
            }
        }
        return unicos.toArray(new String[0]);
    }

    private int binarySearch(String valor, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = claves[mid].compareTo(valor);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void sort(String[] claves, int[] posiciones, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(claves, posiciones, low, high);
            sort(claves, posiciones, low, pivotIndex - 1);
            sort(claves, posiciones, pivotIndex + 1, high);
        }
    }

    private static int partition(String[] claves, int[] posiciones, int low, int high) {
        String pivot = claves[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (claves[j].compareTo(pivot) < 0) {
                i++;

                String tempClave = claves[i];
                claves[i] = claves[j];
                claves[j] = tempClave;

                int tempPos = posiciones[i];
                posiciones[i] = posiciones[j];
                posiciones[j] = tempPos;
            }
        }

        String tempClave = claves[i + 1];
        claves[i + 1] = claves[high];
        claves[high] = tempClave;
        int tempPos = posiciones[i + 1];
        posiciones[i + 1] = posiciones[high];
        posiciones[high] = tempPos;
        return i + 1;
    }
}
