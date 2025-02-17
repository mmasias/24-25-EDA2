public abstract class InstrumentoDigital extends Instrumento implements IElectronico {
  protected boolean conectado;
  protected int volumenActual;

  public InstrumentoDigital(String nombre, String tipo, double precio) {
    super(nombre, tipo, precio);
    this.conectado = false;
    this.volumenActual = 0;
  }

  @Override
  public void conectar() {
    this.conectado = true;
    this.volumenActual = 5;
    System.out.println(nombre + " conectado y listo");
  }

  @Override
  public void ajustarVolumen(int nivel) {
    if (!conectado) {
      System.out.println("Error: Conecte el instrumento primero");
      return;
    }
    if (nivel >= 0 && nivel <= 10) {
      this.volumenActual = nivel;
      System.out.println("Volumen ajustado a: " + nivel);
    } else {
      System.out.println("Error: Nivel de volumen debe estar entre 0 y 10");
    }
  }

  protected boolean estaConectado() {
    return conectado;
  }

  protected int getVolumenActual() {
    return volumenActual;
  }
}