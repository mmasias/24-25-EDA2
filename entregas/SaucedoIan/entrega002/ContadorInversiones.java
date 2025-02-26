public class ContadorInversiones {
  private static class ParInversion {
    int primero, segundo;
    int indicePrimero, indiceSegundo;

    ParInversion(int primero, int segundo, int indicePrimero, int indiceSegundo) {
      this.primero = primero;
      this.segundo = segundo;
      this.indicePrimero = indicePrimero;
      this.indiceSegundo = indiceSegundo;
    }
  }

  public static ParInversion[] encontrarInversionesFuerzaBruta(int[] numeros) {
    ParInversion[] pares = new ParInversion[numeros.length * numeros.length];
    int contador = 0;

    for (int i = 0; i < numeros.length - 1; i++) {
      for (int j = i + 1; j < numeros.length; j++) {
        if (numeros[i] > numeros[j]) {
          pares[contador++] = new ParInversion(numeros[i], numeros[j], i, j);
        }
      }
    }

    ParInversion[] resultado = new ParInversion[contador];
    System.arraycopy(pares, 0, resultado, 0, contador);
    return resultado;
  }

  public static ParInversion[] encontrarInversionesMergeSort(int[] numeros) {
    ParInversion[] inversiones = new ParInversion[numeros.length * numeros.length];
    int[] contadorGlobal = { 0 };
    mergeSortConInversiones(numeros, 0, numeros.length - 1, inversiones, contadorGlobal);

    ParInversion[] resultado = new ParInversion[contadorGlobal[0]];
    System.arraycopy(inversiones, 0, resultado, 0, contadorGlobal[0]);
    return resultado;
  }

  private static void mergeSortConInversiones(int[] numeros, int inicio, int fin,
      ParInversion[] inversiones, int[] contadorGlobal) {
    if (inicio < fin) {
      int medio = (inicio + fin) / 2;
      mergeSortConInversiones(numeros, inicio, medio, inversiones, contadorGlobal);
      mergeSortConInversiones(numeros, medio + 1, fin, inversiones, contadorGlobal);
      mergeConInversiones(numeros, inicio, medio, fin, inversiones, contadorGlobal);
    }
  }

  private static void mergeConInversiones(int[] numeros, int inicio, int medio, int fin,
      ParInversion[] inversiones, int[] contadorGlobal) {
    int[] izquierda = new int[medio - inicio + 1];
    int[] derecha = new int[fin - medio];
    int[] indicesIzq = new int[medio - inicio + 1];
    int[] indicesDer = new int[fin - medio];

    for (int i = 0; i < izquierda.length; i++) {
      izquierda[i] = numeros[inicio + i];
      indicesIzq[i] = inicio + i;
    }
    for (int i = 0; i < derecha.length; i++) {
      derecha[i] = numeros[medio + 1 + i];
      indicesDer[i] = medio + 1 + i;
    }

    int i = 0, j = 0, k = inicio;
    while (i < izquierda.length && j < derecha.length) {
      if (izquierda[i] <= derecha[j]) {
        numeros[k++] = izquierda[i++];
      } else {
        for (int m = i; m < izquierda.length; m++) {
          inversiones[contadorGlobal[0]++] = new ParInversion(
              izquierda[m], derecha[j], indicesIzq[m], indicesDer[j]);
        }
        numeros[k++] = derecha[j++];
      }
    }

    while (i < izquierda.length)
      numeros[k++] = izquierda[i++];
    while (j < derecha.length)
      numeros[k++] = derecha[j++];
  }

  private static void mostrarInversiones(ParInversion[] inversiones) {
    for (ParInversion inv : inversiones) {
      System.out.printf("(%d,%d)[%d,%d] ", inv.primero, inv.segundo,
          inv.indicePrimero, inv.indiceSegundo);
    }
    System.out.println("\nTotal inversiones: " + inversiones.length);
  }

  public static void main(String[] args) {
    int[] numeros = { 2, 4, 1, 3, 5 };
    System.out.println("Arreglo:");
    for (int num : numeros)
      System.out.print(num + " ");
    System.out.println("\n\nInversiones (Fuerza Bruta):");
    mostrarInversiones(encontrarInversionesFuerzaBruta(numeros));

    System.out.println("\nInversiones (Merge Sort):");
    int[] numerosCopia = numeros.clone();
    mostrarInversiones(encontrarInversionesMergeSort(numerosCopia));
  }
}