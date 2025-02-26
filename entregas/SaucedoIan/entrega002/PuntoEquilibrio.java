import java.util.Random;

public class PuntoEquilibrio {
  public static int encontrarEquilibrioFuerzaBruta(int[] numeros) {
    for (int i = 0; i < numeros.length; i++) {
      int sumaIzquierda = 0, sumaDerecha = 0;
      for (int j = 0; j < i; j++)
        sumaIzquierda += numeros[j];
      for (int j = i + 1; j < numeros.length; j++)
        sumaDerecha += numeros[j];
      if (sumaIzquierda == sumaDerecha)
        return i;
    }
    return -1;
  }

  public static int encontrarEquilibrioOptimizado(int[] numeros) {
    int sumaTotal = 0;
    for (int numero : numeros)
      sumaTotal += numero;

    int sumaIzquierda = 0;
    for (int i = 0; i < numeros.length; i++) {
      int sumaDerecha = sumaTotal - sumaIzquierda - numeros[i];
      if (sumaIzquierda == sumaDerecha)
        return i;
      sumaIzquierda += numeros[i];
    }
    return -1;
  }

  private static int[] generarArreglo(int tamano) {
    Random random = new Random();
    int[] arreglo = new int[tamano];
    int puntoEquilibrio = tamano / 2;
    int sumaIzquierda = 0;

    for (int i = 0; i < puntoEquilibrio; i++) {
      arreglo[i] = random.nextInt(10) + 1;
      sumaIzquierda += arreglo[i];
    }

    arreglo[puntoEquilibrio] = random.nextInt(10) + 1;
    arreglo[puntoEquilibrio + 1] = sumaIzquierda;

    for (int i = puntoEquilibrio + 2; i < tamano; i++) {
      arreglo[i] = random.nextInt(10) + 1;
    }
    return arreglo;
  }

  private static void imprimirArreglo(int[] arreglo) {
    System.out.print("[");
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i]);
      if (i < arreglo.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] arregloFijo = { 1, 2, 3, 4, 6 };
    System.out.println("Arreglo fijo:");
    imprimirArreglo(arregloFijo);
    System.out.println("Punto de equilibrio: " + encontrarEquilibrioOptimizado(arregloFijo));

    int[] arregloAleatorio = generarArreglo(7);
    System.out.println("\nArreglo aleatorio:");
    imprimirArreglo(arregloAleatorio);
    System.out.println("Punto de equilibrio: " + encontrarEquilibrioOptimizado(arregloAleatorio));
  }
}