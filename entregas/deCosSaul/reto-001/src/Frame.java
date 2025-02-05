class Frame {
  private Pixel[] frame;

  public Frame(int size) {
    frame = new Pixel[size];
    for (int i = 0; i < size; i++) {
      frame[i] = new Pixel();
    }
  }

  public void modificarPixel(int pos, int nuevoValor) {
    frame[pos].setDato(nuevoValor);
  }

  public char traducir(Pixel pixel) {
    char[] caracteres = { '.', '#', '+', '*' };
    return caracteres[pixel.obtenerDato()];
  }

  public void imprimir() {
    for (int i = 0; i < frame.length; i++) {
      System.out.print(traducir(frame[i]));
      if ((i + 1) % 7 == 0) {
        System.out.println();
      }
    }
  }
}
