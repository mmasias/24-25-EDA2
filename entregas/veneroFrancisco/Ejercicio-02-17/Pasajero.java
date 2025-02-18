public class Pasajero extends Transporte {
    public Pasajero(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("El pasajero ha subido al transporte.");
    }
}