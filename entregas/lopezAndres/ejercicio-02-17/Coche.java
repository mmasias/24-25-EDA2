class Coche extends Vehiculo {
    public Coche(String marca) {
        super(marca);
    }

    @Override
    public void conducir() {
        System.out.println("El coche " + marca + " está en marcha.");
    }

    public void revisarAceite() {
        System.out.println("Revisando el aceite del coche...");
    }
}
