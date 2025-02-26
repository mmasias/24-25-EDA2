public class ElementosCercanos {
  public static int[] encontrarKElementosCercanos(int[] numeros, int k, double objetivo) {
    int izquierda = 0;
    int derecha = numeros.length - k;

    while (izquierda < derecha) {
      int medio = (izquierda + derecha) / 2;

      if (esMejor(numeros, medio + k, medio, objetivo)) {
        izquierda = medio + 1;
      } else {
        derecha = medio;
      }
    }

    int[] resultado = new int[k];
    for (int i = 0; i < k; i++) {
      resultado[i] = numeros[izquierda + i];
    }
    return resultado;
  }

  private static boolean esMejor(int[] numeros, int x, int y, double objetivo) {
    if (y < 0 || y >= numeros.length)
      return false;
    if (x < 0 || x >= numeros.length)
      return true;
    return Math.abs(numeros[x] - objetivo) < Math.abs(numeros[y] - objetivo);
  }

  private static void mostrarArreglo(int[] numeros) {
    System.out.print("[");
    for (int i = 0; i < numeros.length; i++) {
      System.out.print(numeros[i]);
      if (i < numeros.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] numerosEjemplo = { 1, 2, 3, 4, 5 };
    int k = 2;
    double objetivo = 3.7;

    System.out.println("Arreglo original:");
    mostrarArreglo(numerosEjemplo);
    System.out.println("k = " + k);
    System.out.println("Objetivo = " + objetivo);

    int[] resultado = encontrarKElementosCercanos(numerosEjemplo, k, objetivo);
    System.out.println("K elementos más cercanos:");
    mostrarArreglo(resultado);
  }
}