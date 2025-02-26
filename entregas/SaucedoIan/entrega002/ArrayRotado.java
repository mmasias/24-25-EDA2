public class ArrayRotado {
  public static int encontrarPuntoRotacion(int[] numeros) {
    int inicio = 0;
    int fin = numeros.length - 1;

    while (inicio < fin) {
      int medio = inicio + (fin - inicio) / 2;

      if (medio < fin && numeros[medio] > numeros[medio + 1]) {
        return medio + 1;
      }
      if (medio > inicio && numeros[medio - 1] > numeros[medio]) {
        return medio;
      }
      if (numeros[inicio] <= numeros[medio]) {
        inicio = medio + 1;
      } else {
        fin = medio - 1;
      }
    }
    return 0;
  }

  private static void mostrarArreglo(int[] arreglo) {
    System.out.print("[");
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i]);
      if (i < arreglo.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  private static int[] rotarArreglo(int[] original, int posicion) {
    int[] rotado = new int[original.length];
    for (int i = 0; i < original.length; i++) {
      rotado[(i + posicion) % original.length] = original[i];
    }
    return rotado;
  }

  public static void main(String[] args) {
    int[] arreglo = { 4, 5, 6, 1, 2, 3 };
    System.out.println("Arreglo rotado:");
    mostrarArreglo(arreglo);

    int puntoRotacion = encontrarPuntoRotacion(arreglo);
    System.out.println("Punto de rotación: " + puntoRotacion);

    if (puntoRotacion > 0) {
      System.out.println("Arreglo original era:");
      int[] original = rotarArreglo(arreglo, arreglo.length - puntoRotacion);
      mostrarArreglo(original);
    }
  }
}