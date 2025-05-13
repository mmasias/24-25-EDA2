public class GestorCSV {
    private String[][] datos;
    private String[] cabeceras;
    private int filas;
    private int columnas;
    private Object[] indices;
    private boolean[] columnaIndexada;
    private boolean[] columnaOrdenada;

    public GestorCSV(int capacidadMaxima, int numColumnas) {
        datos = new String[capacidadMaxima][numColumnas];
        cabeceras = new String[numColumnas];
        indices = new Object[numColumnas];
        columnaIndexada = new boolean[numColumnas];
        columnaOrdenada = new boolean[numColumnas];
        filas = 0;
        columnas = numColumnas;
    }

    public Object obtenerIndice(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            return null;
        }
        return indices[indiceColumna];
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
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            System.out.println("Columna no encontrada: " + nombreColumna);
            return;
        }

        indices[indiceColumna] = new Indice(filas);
        columnaIndexada[indiceColumna] = true;
        columnaOrdenada[indiceColumna] = false;

        for (int i = 0; i < filas; i++) {
            ((Indice) indices[indiceColumna]).agregar(datos[i][indiceColumna], i);
        }

        System.out.println("> Índice creado para la columna: " + nombreColumna);
    }

    public void crearIndiceOrdenado(String nombreColumna, boolean descendente, String algoritmo) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            System.out.println("Columna no encontrada: " + nombreColumna);
            return;
        }

        TipoOrden tipoOrden = determinarTipoOrden(indiceColumna);
        IndiceOrdenado indice;

        try {
            switch (algoritmo.toLowerCase()) {
                case "quicksort":
                    indice = new IndiceOrdenadoQuickSort(filas, true, tipoOrden);
                    break;
                case "mergesort":
                    indice = new IndiceOrdenadoMergeSort(filas, true, tipoOrden);
                    break;
                case "heapsort":
                    indice = new IndiceOrdenadoHeapSort(filas, true, tipoOrden);
                    break;
                default:
                    System.out.println("Algoritmo de ordenamiento no válido: " + algoritmo);
                    return;
            }

            for (int i = 0; i < filas; i++) {
                indice.agregar(datos[i][indiceColumna], i);
            }

            indices[indiceColumna] = indice;
            columnaIndexada[indiceColumna] = true;
            columnaOrdenada[indiceColumna] = true;

            System.out.println(String.format("> Índice ordenado creado para la columna: %s (%s, %s) usando %s",
                    nombreColumna, tipoOrden.toString().toLowerCase(),
                    descendente ? "descendente" : "ascendente", algoritmo));

        } catch (Exception e) {
            System.out.println("Error al crear el índice ordenado: " + e.getMessage());
        }
    }

    public String[][] buscarPorIndice(String nombreColumna, String valor) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            System.out.println("La columna no está indexada: " + nombreColumna);
            return new String[0][0];
        }

        int[] posiciones;
        if (columnaOrdenada[indiceColumna]) {
            posiciones = ((IndiceOrdenado) indices[indiceColumna]).buscar(valor);
        } else {
            posiciones = ((Indice) indices[indiceColumna]).buscar(valor);
        }

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

    private TipoOrden determinarTipoOrden(int indiceColumna) {
        int valoresNumericos = 0;
        int valoresAnalizados = 0;
        int muestraMaxima = Math.min(filas, 10);

        for (int i = 0; i < filas && valoresAnalizados < muestraMaxima; i++) {
            String valor = datos[i][indiceColumna];
            if (valor != null && !valor.trim().isEmpty()) {
                try {
                    Double.parseDouble(valor.trim());
                    valoresNumericos++;
                } catch (NumberFormatException e) {
                }
                valoresAnalizados++;
            }
        }

        double porcentajeNumerico = (double) valoresNumericos / valoresAnalizados;
        return porcentajeNumerico > 0.7 ? TipoOrden.NUMERICO : TipoOrden.ALFANUMERICO;
    }

    public boolean estaIndexada(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        return indiceColumna != -1 && columnaIndexada[indiceColumna];
    }

    public String[] obtenerValoresUnicos(String nombreColumna) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            System.out.println("La columna no está indexada: " + nombreColumna);
            return new String[0];
        }

        if (columnaOrdenada[indiceColumna]) {
            return ((IndiceOrdenado) indices[indiceColumna]).obtenerValoresOrdenados();
        }
        return ((Indice) indices[indiceColumna]).obtenerTodos();
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
        return datos[fila][columna];
    }
}
