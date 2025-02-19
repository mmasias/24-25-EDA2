class BicicletaMejorada extends VehiculoAbstracto {
  @Override
  void mostrarVelocidad() {
    velocidad();
  }

  private void velocidad() {
    System.out.println("La bicicleta va a 15km/h");
  }

  public void mover() {
    System.out.println("la bicicleta esta pedaleando");
  }
}
