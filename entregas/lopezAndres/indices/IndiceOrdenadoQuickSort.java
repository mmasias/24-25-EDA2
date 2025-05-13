public class IndiceOrdenadoQuickSort extends IndiceOrdenado {

  public IndiceOrdenadoQuickSort(int capacidadMaxima, boolean descendente, TipoOrden tipoOrden) {
    super(capacidadMaxima, descendente, tipoOrden);
  }

  @Override
  protected void ordenar() {
    quickSort(0, cantidadValores - 1);
  }

  private void quickSort(int inicio, int fin) {
    if (inicio < fin) {
      int pivote = particionar(inicio, fin);
      quickSort(inicio, pivote - 1);
      quickSort(pivote + 1, fin);
    }
  }

  private int particionar(int inicio, int fin) {
    String pivote = valores[fin];
    int i = inicio - 1;

    for (int j = inicio; j < fin; j++) {
      if (compararValores(valores[j], pivote) <= 0) {
        i++;
        intercambiar(i, j);
      }
    }
    intercambiar(i + 1, fin);
    return i + 1;
  }
}
