public class PianoDigital extends InstrumentoDigital {
  private int numeroTeclas;
  private String tipoSonido;

  public PianoDigital(String nombre, double precio, int numeroTeclas) {
    super(nombre, "Piano Digital", precio);
    this.numeroTeclas = numeroTeclas;
    this.tipoSonido = "Grand Piano";
  }

  @Override
  public void tocar() {
    if (!estaConectado()) {
      System.out.println("Error: Piano digital no conectado");
      return;
    }
    System.out.println(String.format("♪ Piano digital sonando a volumen %d - Sonido: %s",
        getVolumenActual(), tipoSonido));
  }

  @Override
  public void afinar() {
    if (!estaConectado()) {
      System.out.println("Error: Conecte el piano primero");
      return;
    }
    System.out.println("Calibrando piano digital");
  }

  public void cambiarSonido(String nuevoSonido) {
    if (!estaConectado()) {
      System.out.println("Error: Piano no conectado");
      return;
    }
    this.tipoSonido = nuevoSonido;
    System.out.println("Sonido cambiado a: " + nuevoSonido);
  }

  @Override
  public String toString() {
    return String.format("Piano Digital %s (%d teclas) - Estado: %s - Volumen: %d",
        nombre,
        numeroTeclas,
        estaConectado() ? "Conectado" : "Desconectado",
        getVolumenActual());
  }
}