public class Productor extends Empleado implements Trabajador{
    public void trabajar() {
        System.out.println("Produciendo una nueva canción");
    }

    public void crearInstrumental() {
        System.out.println("Haciendo instrumentales para nuevas canciones");
    }
}
