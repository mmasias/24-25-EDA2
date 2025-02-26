import java.util.Random;

public class CombinacionArrays {
  public static int[] combinarMultiplesArraysOrdenados(int[][] arreglosEntrada) {
    if (arreglosEntrada.length == 0)
      return new int[0];
    if (arreglosEntrada.length == 1)
      return arreglosEntrada[0];

    int[] arregloResultado = arreglosEntrada[0];
    for (int indiceArreglo = 1; indiceArreglo < arreglosEntrada.length; indiceArreglo++) {
      arregloResultado = combinarDosArreglosOrdenados(arregloResultado, arreglosEntrada[indiceArreglo]);
    }
    return arregloResultado;
  }

  private static int[] combinarDosArreglosOrdenados(int[] primerArreglo, int[] segundoArreglo) {
    int[] arregloCombinado = new int[primerArreglo.length + segundoArreglo.length];
    int indicePrimero = 0, indiceSegundo = 0, indiceCombinado = 0;

    while (indicePrimero < primerArreglo.length && indiceSegundo < segundoArreglo.length) {
      if (primerArreglo[indicePrimero] <= segundoArreglo[indiceSegundo]) {
        arregloCombinado[indiceCombinado++] = primerArreglo[indicePrimero++];
      } else {
        arregloCombinado[indiceCombinado++] = segundoArreglo[indiceSegundo++];
      }
    }

    while (indicePrimero < primerArreglo.length) {
      arregloCombinado[indiceCombinado++] = primerArreglo[indicePrimero++];
    }
    while (indiceSegundo < segundoArreglo.length) {
      arregloCombinado[indiceCombinado++] = segundoArreglo[indiceSegundo++];
    }

    return arregloCombinado;
  }

  private static int[][] generarArreglosOrdenadosAleatorios(int cantidadArreglos, int longitudArreglo) {
    int[][] arreglosGenerados = new int[cantidadArreglos][longitudArreglo];
    Random generadorAleatorio = new Random();

    for (int i = 0; i < cantidadArreglos; i++) {
      arreglosGenerados[i][0] = generadorAleatorio.nextInt(5) + 1;
      for (int j = 1; j < longitudArreglo; j++) {
        arreglosGenerados[i][j] = arreglosGenerados[i][j - 1] + generadorAleatorio.nextInt(3) + 1;
      }
    }
    return arreglosGenerados;
  }

  private static void mostrarArreglos(int[][] arreglos) {
    for (int[] arreglo : arreglos) {
      System.out.print("[");
      for (int i = 0; i < arreglo.length; i++) {
        System.out.print(arreglo[i]);
        if (i < arreglo.length - 1)
          System.out.print(", ");
      }
      System.out.println("]");
    }
  }

  public static void main(String[] args) {
    int[][] arreglosEjemplo = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
    System.out.println("Arreglos originales:");
    mostrarArreglos(arreglosEjemplo);

    int[] resultadoCombinacion = combinarMultiplesArraysOrdenados(arreglosEjemplo);
    System.out.print("Arreglo combinado: [");
    for (int i = 0; i < resultadoCombinacion.length; i++) {
      System.out.print(resultadoCombinacion[i]);
      if (i < resultadoCombinacion.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }
}