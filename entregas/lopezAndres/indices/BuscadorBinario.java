public class BuscadorBinario {
  private final IndiceOrdenado indice;

  public BuscadorBinario(IndiceOrdenado indice) {
    this.indice = indice;
  }

  public int[] buscar(String valor) {
    String[] valores = indice.obtenerValoresOrdenados();
    int inicio = 0;
    int fin = valores.length - 1;

    while (inicio <= fin) {
      int medio = inicio + (fin - inicio) / 2;
      int comparacion = indice.compararValores(valores[medio], valor);

      if (comparacion == 0) {
        return indice.buscar(valor);
      }

      if (comparacion < 0) {
        inicio = medio + 1;
      } else {
        fin = medio - 1;
      }
    }

    return new int[0];
  }

  public int[] buscarRango(String valorInicial, String valorFinal) {
    String[] valores = indice.obtenerValoresOrdenados();
    int inicio = encontrarPosicionInicial(valores, valorInicial);
    int fin = encontrarPosicionFinal(valores, valorFinal);

    if (inicio == -1 || fin == -1 || inicio > fin) {
      return new int[0];
    }

    return combinarResultados(valores, inicio, fin);
  }

  private int encontrarPosicionInicial(String[] valores, String valor) {
    int inicio = 0;
    int fin = valores.length - 1;
    int resultado = -1;

    while (inicio <= fin) {
      int medio = inicio + (fin - inicio) / 2;
      int comparacion = indice.compararValores(valores[medio], valor);

      if (comparacion >= 0) {
        resultado = medio;
        fin = medio - 1;
      } else {
        inicio = medio + 1;
      }
    }

    return resultado;
  }

  private int encontrarPosicionFinal(String[] valores, String valor) {
    int inicio = 0;
    int fin = valores.length - 1;
    int resultado = -1;

    while (inicio <= fin) {
      int medio = inicio + (fin - inicio) / 2;
      int comparacion = indice.compararValores(valores[medio], valor);

      if (comparacion <= 0) {
        resultado = medio;
        inicio = medio + 1;
      } else {
        fin = medio - 1;
      }
    }

    return resultado;
  }

  private int[] combinarResultados(String[] valores, int inicio, int fin) {
    int[] resultadoCombinado = new int[0];

    for (int i = inicio; i <= fin; i++) {
      int[] posiciones = indice.buscar(valores[i]);
      resultadoCombinado = unirArrays(resultadoCombinado, posiciones);
    }

    return resultadoCombinado;
  }

  private int[] unirArrays(int[] arr1, int[] arr2) {
    int[] resultado = new int[arr1.length + arr2.length];
    System.arraycopy(arr1, 0, resultado, 0, arr1.length);
    System.arraycopy(arr2, 0, resultado, arr1.length, arr2.length);
    return resultado;
  }
}
