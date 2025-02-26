public class ParesDiferencia {
  public static int[][] encontrarPares(int[] numeros, int k) {
    ordenarArreglo(numeros);
    int[][] pares = new int[numeros.length * numeros.length][2];
    int contador = 0;

    for (int i = 0; i < numeros.length; i++) {
      for (int j = i + 1; j < numeros.length && numeros[j] - numeros[i] <= k; j++) {
        if (numeros[j] - numeros[i] == k) {
          pares[contador][0] = numeros[i];
          pares[contador][1] = numeros[j];
          contador++;
        }
      }
    }

    int[][] resultado = new int[contador][2];
    for (int i = 0; i < contador; i++) {
      resultado[i] = pares[i].clone();
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

  private static void mostrarPares(int[][] pares) {
    System.out.print("[");
    for (int i = 0; i < pares.length; i++) {
      System.out.print("[" + pares[i][0] + "," + pares[i][1] + "]");
      if (i < pares.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] numeros = { 1, 7, 5, 9, 2, 12, 3 };
    int k = 2;

    System.out.println("Arreglo original:");
    for (int num : numeros)
      System.out.print(num + " ");
    System.out.println("\nk = " + k);

    System.out.println("Pares encontrados:");
    mostrarPares(encontrarPares(numeros, k));
  }
}