package v000;

public class IndiceOrdenado {
   private final String[] valores;
   private final int[][] posiciones;
   private final int[] contadores;
   private int cantidadValores;

   public IndiceOrdenado(int capacidadMaxima) {
      this.valores = new String[capacidadMaxima];
      this.posiciones = new int[capacidadMaxima][capacidadMaxima];
      this.contadores = new int[capacidadMaxima];
      this.cantidadValores = 0;
   }

   public void agregar(String valor, int posicion) {
      int indice = buscarIndice(valor);

      if (indice >= 0) {
         posiciones[indice][contadores[indice]] = posicion;
         contadores[indice]++;
      } else {
         int insertPos = encontrarPosicionInsercion(valor);

         for (int i = cantidadValores; i > insertPos; i--) {
            valores[i] = valores[i - 1];
            posiciones[i] = posiciones[i - 1];
            contadores[i] = contadores[i - 1];
         }

         valores[insertPos] = valor;
         posiciones[insertPos] = new int[valores.length];
         posiciones[insertPos][0] = posicion;
         contadores[insertPos] = 1;
         cantidadValores++;
      }
   }

   public int[] buscar(String valor) {
      int indice = buscarIndice(valor);

      if (indice == -1) {
         return new int[0];
      }

      int[] resultado = new int[contadores[indice]];
      System.arraycopy(posiciones[indice], 0, resultado, 0, contadores[indice]);
      return resultado;
   }

   public boolean contiene(String valor) {
      return buscarIndice(valor) != -1;
   }

   public String[] obtenerTodos() {
      String[] resultado = new String[cantidadValores];
      System.arraycopy(valores, 0, resultado, 0, cantidadValores);
      return resultado;
   }

   private int buscarIndice(String valor) {
      int izquierda = 0;
      int derecha = cantidadValores - 1;

      while (izquierda <= derecha) {
         int medio = (izquierda + derecha) / 2;

         if (valores[medio] == null) {
            break;
         }

         int comparacion = valores[medio].compareTo(valor);

         if (comparacion == 0) {
            return medio;
         } else if (comparacion < 0) {
            izquierda = medio + 1;
         } else {
            derecha = medio - 1;
         }
      }
      return -1;
   }

   private int encontrarPosicionInsercion(String valor) {
      int izquierda = 0;
      int derecha = cantidadValores - 1;

      while (izquierda <= derecha) {
         int medio = (izquierda + derecha) / 2;

         if (valores[medio] == null) {
            break;
         }

         int comparacion = valores[medio].compareTo(valor);

         if (comparacion < 0) {
            izquierda = medio + 1;
         } else {
            derecha = medio - 1;
         }
      }
      return izquierda;
   }
}
