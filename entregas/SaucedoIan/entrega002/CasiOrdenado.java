import java.util.Random;

public class CasiOrdenado {
  public static void ordenarCasiOrdenado(int[] numeros, int k) {
    for (int i = 0; i < numeros.length - 1; i++) {
      int minIndex = i;
      int limite = Math.min(i + k + 1, numeros.length);

      for (int j = i + 1; j < limite; j++) {
        if (numeros[j] < numeros[minIndex]) {
          minIndex = j;
        }
      }

      int temp = numeros[i];
      numeros[i] = numeros[minIndex];
      numeros[minIndex] = temp;
    }
  }

  private static int[] generarArregloCasiOrdenado(int tamano, int k) {
    int[] arreglo = new int[tamano];
    for (int i = 0; i < tamano; i++) {
      arreglo[i] = i + 1;
    }

    Random random = new Random();
    for (int i = 0; i < tamano; i++) {
      int j = Math.min(i + random.nextInt(k + 1), tamano - 1);
      int temp = arreglo[i];
      arreglo[i] = arreglo[j];
      arreglo[j] = temp;
    }
    return arreglo;
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
    int[] numerosEjemplo = { 2, 1, 3, 5, 4 };
    int k = 2;

    System.out.println("Arreglo original:");
    mostrarArreglo(numerosEjemplo);

    ordenarCasiOrdenado(numerosEjemplo, k);
    System.out.println("Arreglo ordenado:");
    mostrarArreglo(numerosEjemplo);

    System.out.println("\nPrueba con arreglo aleatorio:");
    int[] arregloAleatorio = generarArregloCasiOrdenado(8, 3);
    System.out.println("Arreglo casi ordenado generado:");
    mostrarArreglo(arregloAleatorio);

    ordenarCasiOrdenado(arregloAleatorio, 3);
    System.out.println("Arreglo ordenado:");
    mostrarArreglo(arregloAleatorio);
  }
}