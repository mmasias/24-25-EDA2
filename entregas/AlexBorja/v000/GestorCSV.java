package v000;

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
}
