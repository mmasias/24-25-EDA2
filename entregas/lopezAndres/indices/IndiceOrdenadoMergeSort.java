public class IndiceOrdenadoMergeSort extends IndiceOrdenado {




  public IndiceOrdenadoMergeSort(int capacidadMaxima, boolean descendente, TipoOrden tipoOrden) {

    super(capacidadMaxima, descendente, tipoOrden);

  }




  @Override

  protected void ordenar() {

    mergeSort(0, cantidadValores - 1);

  }




  private void mergeSort(int inicio, int fin) {

    if (inicio < fin) {

      int medio = (inicio + fin) / 2;

      mergeSort(inicio, medio);

      mergeSort(medio + 1, fin);

      combinar(inicio, medio, fin);

    }

  }




  private void combinar(int inicio, int medio, int fin) {

    String[] tempValores = new String[fin - inicio + 1];

    int[][] tempPosiciones = new int[fin - inicio + 1][];

    int[] tempContadores = new int[fin - inicio + 1];




    int i = inicio, j = medio + 1, k = 0;




    while (i <= medio && j <= fin) {

      if (compararValores(valores[i], valores[j]) <= 0) {

        tempValores[k] = valores[i];

        tempPosiciones[k] = posiciones[i];

        tempContadores[k] = contadores[i];

        i++;

      } else {

        tempValores[k] = valores[j];

        tempPosiciones[k] = posiciones[j];

        tempContadores[k] = contadores[j];

        j++;

      }

      k++;

    }




    while (i <= medio) {

      tempValores[k] = valores[i];

      tempPosiciones[k] = posiciones[i];

      tempContadores[k] = contadores[i];

      i++;

      k++;

    }




    while (j <= fin) {

      tempValores[k] = valores[j];

      tempPosiciones[k] = posiciones[j];

      tempContadores[k] = contadores[j];

      j++;

      k++;

    }




    for (i = 0; i < k; i++) {

      valores[inicio + i] = tempValores[i];

      posiciones[inicio + i] = tempPosiciones[i];

      contadores[inicio + i] = tempContadores[i];

    }

  }

}
