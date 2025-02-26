public class SumaMaxima {
  public static int[] encontrarSubarregloMaximo(int[] numeros) {
    int maxGlobal = numeros[0];
    int maxActual = numeros[0];
    int inicio = 0;
    int fin = 0;
    int inicioTemp = 0;

    for (int i = 1; i < numeros.length; i++) {
      if (numeros[i] > maxActual + numeros[i]) {
        maxActual = numeros[i];
        inicioTemp = i;
      } else {
        maxActual = maxActual + numeros[i];
      }

      if (maxActual > maxGlobal) {
        maxGlobal = maxActual;
        inicio = inicioTemp;
        fin = i;
      }
    }

    int[] resultado = new int[fin - inicio + 1];
    System.arraycopy(numeros, inicio, resultado, 0, resultado.length);
    return resultado;
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

  public static void main(String[] args) {
    int[] numeros = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println("Arreglo original:");
    mostrarArreglo(numeros);

    int[] subarreglo = encontrarSubarregloMaximo(numeros);
    System.out.println("Subarreglo con suma máxima:");
    mostrarArreglo(subarreglo);
  }
}