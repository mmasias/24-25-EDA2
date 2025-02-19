class Bicicleta extends Vehiculo {
  @Override
  public void mover() {
    System.out.println("la bicicleta esta pedaleando");
  }

  public void tocarTimbre() {
    System.out.println("la bicicleta esta tocando el timbre");
  }
}
