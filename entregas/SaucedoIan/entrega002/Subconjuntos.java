public class Subconjuntos {
  public static int[][] generarSubconjuntos(int[] conjunto) {
    int cantidadSubconjuntos = 1 << conjunto.length;
    int[][] subconjuntos = new int[cantidadSubconjuntos][];
    for (int i = 0; i < cantidadSubconjuntos; i++) {
      subconjuntos[i] = generarSubconjunto(conjunto, i);
    }
    return subconjuntos;
  }

  private static int[] generarSubconjunto(int[] conjunto, int mascara) {
    int cantidadElementos = Integer.bitCount(mascara);
    int[] subconjunto = new int[cantidadElementos];
    int indiceSubconjunto = 0;
    for (int i = 0; i < conjunto.length; i++) {
      if ((mascara & (1 << i)) != 0) {
        subconjunto[indiceSubconjunto++] = conjunto[i];
      }
    }
    return subconjunto;
  }

  public static void main(String[] args) {
    int[] conjunto = { 1, 2, 3 };
    int[][] subconjuntos = generarSubconjuntos(conjunto);
    for (int[] subconjunto : subconjuntos) {
      System.out.print("[");
      for (int i = 0; i < subconjunto.length; i++) {
        System.out.print(subconjunto[i]);
        if (i < subconjunto.length - 1)
          System.out.print(", ");
      }
      System.out.println("]");
    }
  }
}
