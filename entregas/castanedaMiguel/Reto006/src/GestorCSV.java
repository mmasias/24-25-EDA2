public class GestorCSV {
    private String[][] datos;
    private String[] cabeceras;
    private int filas;
    private int columnas;
    private IndiceOrdenado[] indices;
    private boolean[] columnaIndexada;

    public GestorCSV(int capacidadMaxima, int numColumnas) {
        datos = new String[capacidadMaxima][numColumnas];
        cabeceras = new String[numColumnas];
        indices = new IndiceOrdenado[numColumnas];
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
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1) {
            System.out.println("Columna no encontrada: " + nombreColumna);
            return;
        }

        indices[indiceColumna] = new IndiceOrdenado(filas);
        columnaIndexada[indiceColumna] = true;

        for (int i = 0; i < filas; i++) {
            indices[indiceColumna].agregar(datos[i][indiceColumna], i);
        }

        System.out.println("> Índice creado para la columna: " + nombreColumna);
    }

    public String[][] buscarPorIndice(String nombreColumna, String valor) {
        int indiceColumna = obtenerIndiceColumna(nombreColumna);
        if (indiceColumna == -1 || !columnaIndexada[indiceColumna]) {
            System.out.println("La columna no está indexada: " + nombreColumna);
            return new String[0][0];
        }

        int[] posiciones = indices[indiceColumna].buscar(valor);

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

    public void imprimirDatosOrdenadosPorIDInsercion() {
        String[][] datosOrdenados = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datosOrdenados[i][j] = datos[i][j];
            }
        }
        for (int i = 1; i < filas; i++) {
            String[] filaActual = datosOrdenados[i];
            String idActual = filaActual[0];
            int j = i - 1;

            while (j >= 0 && compararIDs(datosOrdenados[j][0], idActual) > 0) {
                datosOrdenados[j + 1] = datosOrdenados[j];
                j--;
            }
            datosOrdenados[j + 1] = filaActual;
        }

        for (int i = 0; i < cabeceras.length; i++) {
            System.out.printf("%-25.20s", cabeceras[i]);
        }
        System.out.println();
        System.out.println("=".repeat(60));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-25.20s", datosOrdenados[i][j]);
            }
            System.out.println();
        }
        System.out.println("=".repeat(60));
    }
    // --------------------------------------------------------------------------------------------------

    // --------------------------------------------------------------------------------------------------
    public void imprimirDatosOrdenadosPorIDBubbleSort() {
        String[][] datosOrdenados = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datosOrdenados[i][j] = datos[i][j];
            }
        }

        for (int i = 0; i < filas - 1; i++) {
            for (int j = 0; j < filas - i - 1; j++) {
                if (compararIDs(datosOrdenados[j][0], datosOrdenados[j + 1][0]) > 0) {
                    String[] temp = datosOrdenados[j];
                    datosOrdenados[j] = datosOrdenados[j + 1];
                    datosOrdenados[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < cabeceras.length; i++) {
            System.out.printf("%-25.20s", cabeceras[i]);
        }
        System.out.println();
        System.out.println("=".repeat(60));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-25.20s", datosOrdenados[i][j]);
            }
            System.out.println();
        }
        System.out.println("=".repeat(60));
    }

    // --------------------------------------------------------------------------------------------------
    public void imprimirDatosOrdenadorPorIDQuickSort() {
        String[][] datosOrdenados = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datosOrdenados[i][j] = datos[i][j];
            }
        }

        int high = filas - 1;
        int low = 0;

        sort(datosOrdenados, low, high);

        for (int i = 0; i < cabeceras.length; i++) {
            System.out.printf("%-25.20s", cabeceras[i]);
        }
        System.out.println();
        System.out.println("=".repeat(60));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-25.20s", datosOrdenados[i][j]);
            }
            System.out.println();
        }
        System.out.println("=".repeat(60));
    }

    public void sort(String[][] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private int partition(String[][] array, int low, int high) {
        String pivot = array[high][0];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compararIDs(array[j][0], pivot) < 0) {
                i++;
                String[] temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        String[] temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }



    private int compararIDs(String id1, String id2) {
        try {
            int num1 = Integer.parseInt(id1);
            int num2 = Integer.parseInt(id2);
            return Integer.compare(num1, num2);
        } catch (NumberFormatException e) {
            return id1.compareTo(id2);
        }
    }

}