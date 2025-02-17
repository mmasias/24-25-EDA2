public class GuitarraElectrica extends InstrumentoDigital implements IMusical {
  private int numeroCuerdas;
  private String[] efectos;
  private int efectoActual;

  public GuitarraElectrica(String nombre, double precio, int numeroCuerdas) {
    super(nombre, "Guitarra Eléctrica", precio);
    this.numeroCuerdas = numeroCuerdas;
    this.efectos = new String[] { "Clean", "Overdrive", "Distortion", "Chorus" };
    this.efectoActual = 0;
  }

  @Override
  public void tocar() {
    if (!estaConectado()) {
      System.out.println("Error: Guitarra no conectada");
      return;
    }
    System.out.println(String.format("♪ Guitarra eléctrica de %d cuerdas - Efecto: %s - Volumen: %d",
        numeroCuerdas, efectos[efectoActual], getVolumenActual()));
  }

  @Override
  public void afinar() {
    System.out.println("Afinando guitarra eléctrica de " + numeroCuerdas + " cuerdas");
  }

  public void cambiarEfecto() {
    if (!estaConectado()) {
      System.out.println("Error: Guitarra no conectada");
      return;
    }
    efectoActual = (efectoActual + 1) % efectos.length;
    System.out.println("Efecto cambiado a: " + efectos[efectoActual]);
  }

  public void hacerSolo() {
    if (!estaConectado()) {
      System.out.println("Error: Guitarra no conectada");
      return;
    }
    System.out.println("¡Realizando solo de guitarra! 🎸");
  }

  @Override
  public String toString() {
    return String.format("Guitarra Eléctrica %s (%d cuerdas) - Estado: %s - Efecto: %s - Volumen: %d",
        nombre,
        numeroCuerdas,
        estaConectado() ? "Conectada" : "Desconectada",
        efectos[efectoActual],
        getVolumenActual());
  }
}