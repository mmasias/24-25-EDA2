class Camion extends Vehiculo {
    public Camion(String marca) {
        super(marca);
    }

    @Override
    public void conducir() {
        System.out.println("El camión " + marca + " transporta carga pesada.");
    }
}
