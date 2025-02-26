public class TripletesSum {
  public static int[][] encontrarTripletes(int[] numeros) {
    ordenarArreglo(numeros);
    int[][] tripletes = new int[numeros.length * numeros.length][3];
    int contador = 0;

    for (int i = 0; i < numeros.length - 2; i++) {
      if (i > 0 && numeros[i] == numeros[i - 1])
        continue;

      int izquierda = i + 1;
      int derecha = numeros.length - 1;

      while (izquierda < derecha) {
        int suma = numeros[i] + numeros[izquierda] + numeros[derecha];

        if (suma == 0) {
          tripletes[contador][0] = numeros[i];
          tripletes[contador][1] = numeros[izquierda];
          tripletes[contador][2] = numeros[derecha];
          contador++;

          while (izquierda < derecha && numeros[izquierda] == numeros[izquierda + 1])
            izquierda++;
          while (izquierda < derecha && numeros[derecha] == numeros[derecha - 1])
            derecha--;

          izquierda++;
          derecha--;
        } else if (suma < 0) {
          izquierda++;
        } else {
          derecha--;
        }
      }
    }

    int[][] resultado = new int[contador][3];
    for (int i = 0; i < contador; i++) {
      System.arraycopy(tripletes[i], 0, resultado[i], 0, 3);
    }
    return resultado;
  }

  private static void ordenarArreglo(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  private static void mostrarTripletes(int[][] tripletes) {
    System.out.println("[");
    for (int i = 0; i < tripletes.length; i++) {
      System.out.print("  [");
      for (int j = 0; j < 3; j++) {
        System.out.print(tripletes[i][j]);
        if (j < 2)
          System.out.print(",");
      }
      System.out.print("]");
      if (i < tripletes.length - 1)
        System.out.println(",");
    }
    System.out.println("\n]");
  }

  public static void main(String[] args) {
    int[] numeros = { -1, 0, 1, 2, -1, -4 };
    System.out.println("Array original:");
    for (int num : numeros)
      System.out.print(num + " ");
    System.out.println("\n\nTripletes encontrados:");
    mostrarTripletes(encontrarTripletes(numeros.clone()));
  }
}