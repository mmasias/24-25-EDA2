public class ElementoUnico {
  public static int encontrarElementoUnico(int[] numeros) {
    int resultado = 0;
    for (int numero : numeros) {
      resultado ^= numero;
    }
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
    int[] numeros = { 1, 2, 1, 3, 2 };
    System.out.println("Arreglo:");
    mostrarArreglo(numeros);

    int unico = encontrarElementoUnico(numeros);
    System.out.println("Elemento único: " + unico);
  }
}