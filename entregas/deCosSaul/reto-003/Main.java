class Main {
  public static void main(String[] args) {

    numeroFaltante(new int[] { 1, 2, 4, 5, 6 });

  }

  private void sumaObjetivo(int[] numeros, int objetivo) {

  }

  private void busquedaPalabra(int[] numeros, int objetivo) {

  }

  private static void numeroFaltante(int[] numeros) {

    for (int i = 1; i < numeros.length - 1; i++) {
      if ((numeros[i] + 1) != numeros[i + 1]) {
        System.out.println("Salida: " + (numeros[i] + 1));
      }
    }

  }
}
