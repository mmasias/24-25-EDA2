public class Vehiculo extends Transporte {
    public Vehiculo(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("El vehículo arranca.");
    }

    public void repostar() {
        System.out.println("El vehículo ha sido repostado.");
    }
}