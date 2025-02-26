public class TriangulosPosibles {
  public static int[] encontrarTriangulo(int[] numeros) {
    ordenarArreglo(numeros);

    for (int i = 0; i < numeros.length - 2; i++) {
      if (numeros[i] + numeros[i + 1] > numeros[i + 2]) {
        return new int[] { numeros[i], numeros[i + 1], numeros[i + 2] };
      }
    }
    return new int[0];
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

  private static void mostrarArreglo(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i < arr.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] numeros = { 3, 4, 5, 6, 7 };
    System.out.println("Números disponibles:");
    mostrarArreglo(numeros);

    int[] triangulo = encontrarTriangulo(numeros.clone());
    if (triangulo.length > 0) {
      System.out.print("Triángulo encontrado: ");
      mostrarArreglo(triangulo);
    } else {
      System.out.println("No se encontró triángulo posible");
    }
  }
}