public class ProductoDefectuoso {
  public static int encontrarProductoDefectuoso(int[] numeros) {
    int producto = 1;
    for (int numero : numeros) {
      producto *= numero;
    }
    return producto;
  }

  public static void main(String[] args) {
    int[] numeros = { 1, 2, 3, 4, 5 };
    System.out.println("Arreglo:");
    mostrarArreglo(numeros);

    int producto = encontrarProductoDefectuoso(numeros);
    System.out.println("Producto defectuoso: " + producto);
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
}
