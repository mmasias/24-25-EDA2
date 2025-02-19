class BicicletaElectrica extends BicicletaMejorada {
  @Override
  public void mover() {
    super.mover();
    System.out.println("la bici electrica esta acelerando");
  }
}
