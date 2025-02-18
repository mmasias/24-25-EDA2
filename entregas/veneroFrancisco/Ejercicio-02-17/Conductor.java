public class Conductor extends Transporte {
    public Conductor(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("El conductor enciende el motor.");
    }

    public void iniciarRuta() {
        System.out.println("El conductor ha iniciado la ruta.");
    }

    public void conducir() {
        System.out.println("El conductor está conduciendo.");
    }
}