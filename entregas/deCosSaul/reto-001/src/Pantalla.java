class Pantalla {
  private Frame[] pantalla = new Frame[2];

  public Frame generarFrame(int posicion) {
    Frame frame = new Frame(21);

    for (int i = 1; i < 21; i++) {
      int randomNumber = (int) (Math.random() * 4);
      frame.modificarPixel(i, randomNumber);
    }

    return frame;

  }

  public void addFrame(int pos) {
    pantalla[pos] = generarFrame(pos);
  }

  public void mostrarFrame(int posicion) {
    pantalla[posicion].imprimir();
  }

  public void modificarPixel(int frame, int pos, int nuevoValor) {
    pantalla[frame].modificarPixel(pos, nuevoValor);
  }
}
