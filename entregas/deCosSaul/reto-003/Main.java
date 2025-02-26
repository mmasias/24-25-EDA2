class Main {
  public static void main(String[] args) {

    numeroFaltante(new int[] { 1, 2, 4, 5, 6 });

    System.out.println(montana(new int[] { 1, 3, 5, 4, 2 }));
  }

  private static void sumaObjetivo(int[] numeros, int objetivo) {

  }

  private static void busquedaPalabra(int[] numeros, int objetivo) {

  }

  private static void numeroFaltante(int[] numeros) {

    for (int i = 1; i < numeros.length - 1; i++) {
      if ((numeros[i] + 1) != numeros[i + 1]) {
        System.out.println("Salida: " + (numeros[i] + 1));
      }
    }

  }

  private static boolean montana(int[] numeros) {

    int indice = 0;
    boolean creciendo = true;
    boolean decreciendo = false;

    while (creciendo) {
      if (indice + 1 == numeros.length) {
        return true;
      }
      if (numeros[indice + 1] > numeros[indice]) {
      } else {
        creciendo = false;
        decreciendo = true;
      }
      indice++;
    }

    while (decreciendo) {
      if (indice + 1 == numeros.length) {
        return true;
      }
      if (numeros[indice + 1] > numeros[indice]) {
        return false;
      }
      indice++;
    }
    return true;
  }
}
