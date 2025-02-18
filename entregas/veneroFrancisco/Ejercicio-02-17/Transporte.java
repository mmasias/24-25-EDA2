public class Transporte {
    String nombre;

    public Transporte(String nombre) {
        this.nombre = nombre;
    }

    public void iniciar() {
        System.out.println("El transporte está en marcha.");
    }

    public void mostrarInfo() {
        System.out.println("Transporte: " + nombre);
    }
}