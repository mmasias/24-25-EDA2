import java.util.Random;

public class SumaObjetivo {
  public static int[] encontrarParejaSumaFuerzaBruta(int[] numeros, int objetivo) {
    for (int i = 0; i < numeros.length; i++) {
      for (int j = i + 1; j < numeros.length; j++) {
        if (numeros[i] + numeros[j] == objetivo) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] { -1, -1 };
  }

  public static int[] encontrarParejaSumaOptimizada(int[] numeros, int objetivo) {
    int[] complementos = new int[1001];

    for (int i = 0; i < numeros.length; i++) {
      int complemento = objetivo - numeros[i];

      if (complemento >= 0 && complemento <= 1000) {
        if (complementos[complemento] != 0) {
          return new int[] { complementos[complemento] - 1, i };
        }
      }
      complementos[numeros[i]] = i + 1;
    }
    return new int[] { -1, -1 };
  }

  private static int[] generarArregloAleatorio(int tamano, int valorMaximo) {
    Random random = new Random();
    int[] arreglo = new int[tamano];
    for (int i = 0; i < tamano; i++) {
      arreglo[i] = random.nextInt(valorMaximo + 1);
    }
    return arreglo;
  }

  private static int generarObjetivoAleatorio(int valorMaximo) {
    return new Random().nextInt(valorMaximo + 1);
  }

  private static void imprimirArreglo(int[] arreglo) {
    System.out.print("Arreglo: [");
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i]);
      if (i < arreglo.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  private static void imprimirResultado(int[] indices, int[] numeros, int objetivo) {
    if (indices[0] == -1) {
      System.out.println("No se encontró solución");
    } else {
      System.out.printf("Índices: [%d, %d] (números: %d + %d = %d)%n",
          indices[0], indices[1],
          numeros[indices[0]], numeros[indices[1]],
          objetivo);
    }
  }

  public static void main(String[] args) {
    System.out.println("=== Caso de Prueba Fijo ===");
    int[] numerosFijos = { 3, 2, 9, 8 };
    int objetivoFijo = 10;

    imprimirArreglo(numerosFijos);
    System.out.println("Objetivo: " + objetivoFijo);

    System.out.println("\nMétodo Fuerza Bruta:");
    imprimirResultado(encontrarParejaSumaFuerzaBruta(numerosFijos, objetivoFijo),
        numerosFijos, objetivoFijo);

    System.out.println("\nMétodo Optimizado:");
    imprimirResultado(encontrarParejaSumaOptimizada(numerosFijos, objetivoFijo),
        numerosFijos, objetivoFijo);

    System.out.println("\n=== Caso de Prueba Aleatorio ===");
    int tamano = 8;
    int valorMaximo = 20;

    int[] numerosAleatorios = generarArregloAleatorio(tamano, valorMaximo);
    int objetivoAleatorio = generarObjetivoAleatorio(valorMaximo * 2);

    imprimirArreglo(numerosAleatorios);
    System.out.println("Objetivo: " + objetivoAleatorio);

    System.out.println("\nMétodo Fuerza Bruta:");
    imprimirResultado(encontrarParejaSumaFuerzaBruta(numerosAleatorios, objetivoAleatorio),
        numerosAleatorios, objetivoAleatorio);

    System.out.println("\nMétodo Optimizado:");
    imprimirResultado(encontrarParejaSumaOptimizada(numerosAleatorios, objetivoAleatorio),
        numerosAleatorios, objetivoAleatorio);
  }
}