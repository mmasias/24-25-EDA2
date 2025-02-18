public class Cantante extends Empleado implements Trabajador {
    public void trabajar() {
        System.out.println("Cantando cancion");
    }

    public void escribirCancion() {
        System.out.println("Escribiendo una cancion...");
    }
}
