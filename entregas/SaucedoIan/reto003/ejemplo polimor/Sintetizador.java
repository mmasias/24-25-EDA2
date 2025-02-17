public class Sintetizador extends InstrumentoDigital {
  private String tipoSonido;
  private String[] efectos;
  private int efectoActual;

  public Sintetizador(String nombre, double precio, String tipoSonido) {
    super(nombre, "Sintetizador Digital", precio);
    this.tipoSonido = tipoSonido;
    this.efectos = new String[] { "Normal", "Reverb", "Delay", "Chorus" };
    this.efectoActual = 0;
  }

  @Override
  public void tocar() {
    if (!estaConectado()) {
      System.out.println("Error: Sintetizador no conectado");
      return;
    }
    System.out.println(String.format("♪ Sintetizador sonando [%s] - Efecto: %s - Volumen: %d",
        tipoSonido, efectos[efectoActual], getVolumenActual()));
  }

  @Override
  public void afinar() {
    if (!estaConectado()) {
      System.out.println("Error: Conecte el sintetizador primero");
      return;
    }
    System.out.println("Calibrando sintetizador digital");
  }

  public void cambiarSonido(String nuevoSonido) {
    if (!estaConectado()) {
      System.out.println("Error: Sintetizador no conectado");
      return;
    }
    this.tipoSonido = nuevoSonido;
    System.out.println("Sonido cambiado a: " + nuevoSonido);
  }

  public void cambiarEfecto() {
    if (!estaConectado()) {
      System.out.println("Error: Sintetizador no conectado");
      return;
    }
    efectoActual = (efectoActual + 1) % efectos.length;
    System.out.println("Efecto cambiado a: " + efectos[efectoActual]);
  }

  @Override
  public String toString() {
    return String.format("Sintetizador %s - Estado: %s - Sonido: %s - Efecto: %s - Volumen: %d",
        nombre,
        estaConectado() ? "Conectado" : "Desconectado",
        tipoSonido,
        efectos[efectoActual],
        getVolumenActual());
  }
}