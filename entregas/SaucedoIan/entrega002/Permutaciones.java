public class Permutaciones {
  public static String[] generarPermutaciones(String entrada) {
    char[] caracteres = entrada.toCharArray();
    String[] resultado = new String[factorial(entrada.length())];
    int[] indice = { 0 };
    permutarRecursivo(caracteres, 0, resultado, indice);
    return resultado;
  }

  private static void permutarRecursivo(char[] caracteres, int posicion, String[] resultado, int[] indice) {
    if (posicion == caracteres.length) {
      resultado[indice[0]++] = new String(caracteres);
      return;
    }

    for (int i = posicion; i < caracteres.length; i++) {
      intercambiar(caracteres, posicion, i);
      permutarRecursivo(caracteres, posicion + 1, resultado, indice);
      intercambiar(caracteres, posicion, i);
    }
  }

  private static void intercambiar(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static int factorial(int n) {
    int resultado = 1;
    for (int i = 2; i <= n; i++) {
      resultado *= i;
    }
    return resultado;
  }

  private static void mostrarPermutaciones(String[] permutaciones) {
    System.out.print("[");
    for (int i = 0; i < permutaciones.length; i++) {
      System.out.print("\"" + permutaciones[i] + "\"");
      if (i < permutaciones.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    String entrada = "abc";
    System.out.println("Entrada: \"" + entrada + "\"");
    System.out.println("Permutaciones:");
    mostrarPermutaciones(generarPermutaciones(entrada));
  }
}