public abstract class IndiceOrdenado {
  protected String[] valores;
  protected int[][] posiciones;
  protected int[] contadores;
  protected int cantidadValores;
  protected boolean descendente;
  protected TipoOrden tipoOrden;

  public IndiceOrdenado(int capacidadMaxima, boolean descendente, TipoOrden tipoOrden) {
    this.valores = new String[capacidadMaxima];
    this.posiciones = new int[capacidadMaxima][capacidadMaxima];
    this.contadores = new int[capacidadMaxima];
    this.cantidadValores = 0;
    this.descendente = descendente;
    this.tipoOrden = tipoOrden;
  }

  protected abstract void ordenar();

  protected boolean esNumerico(String valor) {
    try {
      Double.parseDouble(valor);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  protected int compararValores(String valor1, String valor2) {
    if (tipoOrden == TipoOrden.NUMERICO && esNumerico(valor1) && esNumerico(valor2)) {
      double num1 = Double.parseDouble(valor1);
      double num2 = Double.parseDouble(valor2);
      return descendente ? Double.compare(num2, num1) : Double.compare(num1, num2);
    }
    return descendente ? valor2.compareTo(valor1) : valor1.compareTo(valor2);
  }

  public void agregar(String valor, int posicion) {
    int indiceValor = -1;

    for (int i = 0; i < cantidadValores && indiceValor == -1; i++) {
      if (valores[i].equals(valor)) {
        indiceValor = i;
      }
    }

    if (indiceValor == -1) {
      valores[cantidadValores] = valor;
      indiceValor = cantidadValores;
      cantidadValores++;
      ordenar();
    }

    posiciones[indiceValor][contadores[indiceValor]] = posicion;
    contadores[indiceValor]++;
  }

  public int[] buscar(String valor) {
    int indiceValor = -1;

    for (int i = 0; i < cantidadValores && indiceValor == -1; i++) {
      if (valores[i].equals(valor)) {
        indiceValor = i;
      }
    }

    if (indiceValor == -1) {
      return new int[0];
    }

    int[] resultado = new int[contadores[indiceValor]];
    System.arraycopy(posiciones[indiceValor], 0, resultado, 0, contadores[indiceValor]);
    return resultado;
  }

  public String[] obtenerValoresOrdenados() {
    String[] resultado = new String[cantidadValores];
    System.arraycopy(valores, 0, resultado, 0, cantidadValores);
    return resultado;
  }

  protected void intercambiar(int i, int j) {
    String tempValor = valores[i];
    valores[i] = valores[j];
    valores[j] = tempValor;

    int[] tempPosiciones = posiciones[i];
    posiciones[i] = posiciones[j];
    posiciones[j] = tempPosiciones;

    int tempContador = contadores[i];
    contadores[i] = contadores[j];
    contadores[j] = tempContador;
  }
}
