class Moto extends Vehiculo {
    public Moto(String marca) {
        super(marca);
    }

    @Override
    public void conducir() {
        System.out.println("La moto " + marca + " está acelerando.");
    }
}
