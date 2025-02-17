public class PianoAnalogo extends Instrumento {
  private int numeroTeclas;
  private String tipoMadera;
  private boolean afinado;

  public PianoAnalogo(String nombre, double precio, int numeroTeclas, String tipoMadera) {
    super(nombre, "Piano Análogo", precio);
    validarDatos(numeroTeclas, tipoMadera);
    this.numeroTeclas = numeroTeclas;
    this.tipoMadera = tipoMadera;
    this.afinado = false;
  }

  private void validarDatos(int numeroTeclas, String tipoMadera) {
    if (numeroTeclas <= 0) {
      throw new IllegalArgumentException("El número de teclas debe ser positivo");
    }
    if (tipoMadera == null || tipoMadera.trim().isEmpty()) {
      throw new IllegalArgumentException("El tipo de madera no puede estar vacío");
    }
  }

  @Override
  public void tocar() {
    String estadoAfinacion = afinado ? "afinado" : "desafinado";
    System.out.println(String.format("♪ Piano análogo de %s sonando %s",
        tipoMadera, estadoAfinacion));
  }

  @Override
  public void afinar() {
    this.afinado = true;
    System.out.println("Afinando piano análogo manualmente");
  }

  public int getNumeroTeclas() {
    return numeroTeclas;
  }

  public String getTipoMadera() {
    return tipoMadera;
  }

  public boolean isAfinado() {
    return afinado;
  }

  @Override
  public void mostrarInfo() {
    super.mostrarInfo();
    System.out.println("Número de teclas: " + numeroTeclas);
    System.out.println("Tipo de madera: " + tipoMadera);
    System.out.println("Estado: " + (afinado ? "Afinado" : "Desafinado"));
  }

  @Override
  public String toString() {
    return String.format("Piano Análogo %s (%d teclas) - Madera: %s - Estado: %s",
        nombre,
        numeroTeclas,
        tipoMadera,
        afinado ? "Afinado" : "Desafinado");
  }
}