import java.util.Random;

public class NumeroFaltante {
  public static int encontrarFaltanteSuma(int[] numeros) {
    int n = numeros.length + 1;
    int sumaEsperada = (n * (n + 1)) / 2;
    int sumaActual = 0;

    for (int numero : numeros) {
      sumaActual += numero;
    }
    return sumaEsperada - sumaActual;
  }

  public static int encontrarFaltanteXOR(int[] numeros) {
    int n = numeros.length + 1;
    int xorTotal = 0;

    for (int i = 1; i <= n; i++) {
      xorTotal ^= i;
    }

    for (int numero : numeros) {
      xorTotal ^= numero;
    }
    return xorTotal;
  }

  private static int[] generarArreglo(int n, int faltante) {
    int[] numeros = new int[n - 1];
    int index = 0;

    for (int i = 1; i <= n; i++) {
      if (i != faltante) {
        numeros[index++] = i;
      }
    }
    return numeros;
  }

  private static void imprimirArreglo(int[] numeros) {
    System.out.print("[");
    for (int i = 0; i < numeros.length; i++) {
      System.out.print(numeros[i]);
      if (i < numeros.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] arregloFijo = { 1, 2, 4, 5, 6 };
    System.out.println("Arreglo fijo:");
    imprimirArreglo(arregloFijo);
    System.out.println("Faltante (Suma): " + encontrarFaltanteSuma(arregloFijo));
    System.out.println("Faltante (XOR): " + encontrarFaltanteXOR(arregloFijo));

    int n = 20;
    int faltanteAleatorio = new Random().nextInt(n) + 1;
    int[] arregloAleatorio = generarArreglo(n, faltanteAleatorio);

    System.out.println("\nArreglo aleatorio:");
    imprimirArreglo(arregloAleatorio);
    System.out.println("Número faltante: " + faltanteAleatorio);
    System.out.println("Encontrado (Suma): " + encontrarFaltanteSuma(arregloAleatorio));
    System.out.println("Encontrado (XOR): " + encontrarFaltanteXOR(arregloAleatorio));
  }
}