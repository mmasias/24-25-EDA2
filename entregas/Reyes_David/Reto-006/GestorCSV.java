import java.util.ArrayList;
import java.util.List;

public class GestorCSV {
    private String[][] datos;
    private String[] cabeceras;
    private int filas;
    private int columnas;
    private Indice[] indices;
    private boolean[] columnaIndexada;

    public GestorCSV(int capacidadMaxima, int numColumnas) {
        datos = new String[capacidadMaxima][numColumnas];
        cabeceras = new String[numColumnas];
        indices = new Indice[numColumnas];
        columnaIndexada = new boolean[numColumnas];
        filas = 0;
        columnas = numColumnas;
    }

    public void cargarDatos(String[] cabeceras, String[][] datosEntrada) {
        this.cabeceras = cabeceras;

        filas = datosEntrada.length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = datosEntrada[i][j];
            }
        }
        System.out.println("> Datos cargados");
    }

    public void crearIndice(String nombreColumna) {
        crearIndice(nombreColumna, new QuickSort());
    }

    public void crearIndice(String nombreColumna, AlgoritmoOrdenacion algoritmo) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            System.out.println("Columna no encontrada: " + nombreColumna);
            return;
        }

        indices[indiceColumna] = new Indice(filas, algoritmo);
        columnaIndexada[indiceColumna] = true;

        for (int i = 0; i < filas; i++) {
            indices[indiceColumna].agregar(datos[i][indiceColumna], i);
        }

        System.out.println("> Índice creado para la columna: " + nombreColumna);
    }

    public void crearIndiceOrdenado(String nombreColumna, boolean descendente, String algoritmoNombre) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            System.out.println("Columna no encontrada: " + nombreColumna);
            return;
        }

        AlgoritmoOrdenacion algoritmo = obtenerAlgoritmoOrdenacion(algoritmoNombre);
        IndiceOrdenado indice = new IndiceOrdenado(filas, algoritmo, descendente);

        boolean esNumerico = true;
        try {
            for (int i = 0; i < filas; i++) {
                Integer.parseInt(datos[i][indiceColumna]);
            }
        } catch (NumberFormatException e) {
            esNumerico = false;
        }
        indice.setEsNumerico(esNumerico);

        indices[indiceColumna] = indice;
        columnaIndexada[indiceColumna] = true;

        for (int i = 0; i < filas; i++) {
            indices[indiceColumna].agregar(datos[i][indiceColumna], i);
        }

        System.out.println("> Índice ordenado creado para: " + nombreColumna +
                " (" + (esNumerico ? "Numérico" : "Texto") + ")");
    }

    private AlgoritmoOrdenacion obtenerAlgoritmoOrdenacion(String nombre) {
        switch (nombre.toLowerCase()) {
            case "quicksort":
                return new QuickSort();
            case "mergesort":
                return new MergeSort();
            case "heapsort":
                return new HeapSort();
            default:
                return new QuickSort();
        }
    }

    public String[][] buscarPorIndice(String nombreColumna, String valor) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            System.out.println("La columna no está indexada: " + nombreColumna);
            return new String[0][0];
        }

        int[] posiciones = indices[indiceColumna].buscar(valor);

        if (posiciones.length == 0) {
            List<Integer> matches = new ArrayList<>();
            for (int i = 0; i < filas; i++) {
                if (datos[i][indiceColumna].equals(valor)) {
                    matches.add(i);
                }
            }
            posiciones = matches.stream().mapToInt(i -> i).toArray();
        }

        return obtenerFilasPorPosiciones(posiciones);
    }

    private String[][] obtenerFilasPorPosiciones(int[] posiciones) {
        String[][] resultado = new String[posiciones.length][columnas];
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = datos[posiciones[i]][j];
            }
        }
        return resultado;
    }

    private int obtenerIndiceColumna(String nombreColumna) {
        for (int i = 0; i < cabeceras.length; i++) {
            if (cabeceras[i].equals(nombreColumna)) {
                return i;
            }
        }
        return -1;
    }

    public boolean estaIndexada(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            return false;
        }
        return columnaIndexada[indiceColumna];
    }

    public Indice obtenerIndice(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            return null;
        }
        return indices[indiceColumna];
    }

    public String[] obtenerValoresUnicos(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            System.out.println("La columna no está indexada: " + nombreColumna);
            return new String[0];
        }

        return indices[indiceColumna].obtenerTodos();
    }

    public void imprimirDatos() {
        for (int i = 0; i < cabeceras.length; i++) {
            System.out.printf("%-25.20s", cabeceras[i]);
        }
        System.out.println();
        System.out.println("=".repeat(60));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-25.20s", datos[i][j]);
            }
            System.out.println();
        }
        System.out.println("=".repeat(60));
    }

    public int getColumnas() {
        return columnas;
    }

    public String getDato(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return datos[fila][columna];
        }
        return null;
    }

    public String[] getCabeceras() {
        return cabeceras.clone();
    }
}