import java.util.Random;

public class BusquedaPalabra {
  public static int[] buscarPalabraFuerzaBruta(char[] letras, String palabra) {
    int[] indices = new int[3];
    boolean[] usado = new boolean[letras.length];

    for (int i = 0; i < letras.length; i++) {
      if (letras[i] == palabra.charAt(0)) {
        indices[0] = i;
        usado[i] = true;
        for (int j = 0; j < letras.length; j++) {
          if (!usado[j] && letras[j] == palabra.charAt(1)) {
            indices[1] = j;
            usado[j] = true;
            for (int k = 0; k < letras.length; k++) {
              if (!usado[k] && letras[k] == palabra.charAt(2)) {
                indices[2] = k;
                return indices;
              }
            }
            usado[j] = false;
          }
        }
        usado[i] = false;
      }
    }
    return new int[] { -1, -1, -1 };
  }

  public static int[] buscarPalabraOptimizada(char[] letras, String palabra) {
    int[] indices = new int[3];
    boolean[] posiciones = new boolean[26];
    int[] primeraPosicion = new int[26];

    for (int i = 0; i < letras.length; i++) {
      int indice = letras[i] - 'a';
      if (!posiciones[indice]) {
        posiciones[indice] = true;
        primeraPosicion[indice] = i;
      }
    }

    for (int i = 0; i < 3; i++) {
      int letraIndice = palabra.charAt(i) - 'a';
      if (!posiciones[letraIndice]) {
        return new int[] { -1, -1, -1 };
      }
      indices[i] = primeraPosicion[letraIndice];
    }
    return indices;
  }

  private static char[] generarArregloLetras(int tamano) {
    char[] letras = new char[tamano];
    Random random = new Random();
    for (int i = 0; i < tamano; i++) {
      letras[i] = (char) ('a' + random.nextInt(26));
    }
    return letras;
  }

  private static void imprimirArreglo(char[] letras) {
    System.out.print("Letras: [");
    for (int i = 0; i < letras.length; i++) {
      System.out.print("'" + letras[i] + "'");
      if (i < letras.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  private static void imprimirResultado(int[] indices, char[] letras) {
    if (indices[0] == -1) {
      System.out.println("No se encontró la palabra");
      return;
    }
    System.out.print("Índices encontrados: [");
    for (int i = 0; i < indices.length; i++) {
      System.out.print(indices[i]);
      if (i < indices.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    char[] letrasFijas = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };
    String palabraPrueba = "dia";

    System.out.println("=== Caso de Prueba Fijo ===");
    imprimirArreglo(letrasFijas);
    System.out.println("Palabra a buscar: " + palabraPrueba);

    System.out.println("\nMétodo Fuerza Bruta:");
    imprimirResultado(buscarPalabraFuerzaBruta(letrasFijas, palabraPrueba), letrasFijas);

    System.out.println("\nMétodo Optimizado:");
    imprimirResultado(buscarPalabraOptimizada(letrasFijas, palabraPrueba), letrasFijas);

    System.out.println("\n=== Caso de Prueba Aleatorio ===");
    char[] letrasAleatorias = generarArregloLetras(10);
    String palabraAleatoria = "hi";

    imprimirArreglo(letrasAleatorias);
    System.out.println("Palabra a buscar: " + palabraAleatoria);

    System.out.println("\nMétodo Fuerza Bruta:");
    imprimirResultado(buscarPalabraFuerzaBruta(letrasAleatorias, palabraAleatoria), letrasAleatorias);

    System.out.println("\nMétodo Optimizado:");
    imprimirResultado(buscarPalabraOptimizada(letrasAleatorias, palabraAleatoria), letrasAleatorias);
  }
}