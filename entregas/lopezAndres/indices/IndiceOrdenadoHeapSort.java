public class IndiceOrdenadoHeapSort extends IndiceOrdenado {

  public IndiceOrdenadoHeapSort(int capacidadMaxima, boolean descendente, TipoOrden tipoOrden) {
    super(capacidadMaxima, descendente, tipoOrden);
  }

  @Override
  protected void ordenar() {
    construirHeap();
    for (int i = cantidadValores - 1; i > 0; i--) {
      intercambiar(0, i);
      heapify(i, 0);
    }

    if (descendente) {
      invertirArreglo();
    }
  }

  private void construirHeap() {
    for (int i = cantidadValores / 2 - 1; i >= 0; i--) {
      heapify(cantidadValores, i);
    }
  }

  private void heapify(int n, int i) {
    int raiz = i;
    int izquierdo = 2 * i + 1;
    int derecho = 2 * i + 2;

    if (izquierdo < n && compararValores(valores[izquierdo], valores[raiz]) > 0) {
      raiz = izquierdo;
    }

    if (derecho < n && compararValores(valores[derecho], valores[raiz]) > 0) {
      raiz = derecho;
    }

    if (raiz != i) {
      intercambiar(i, raiz);
      heapify(n, raiz);
    }
  }

  private void invertirArreglo() {
    int inicio = 0;
    int fin = cantidadValores - 1;

    while (inicio < fin) {
      intercambiar(inicio, fin);
      inicio++;
      fin--;
    }
  }
}
