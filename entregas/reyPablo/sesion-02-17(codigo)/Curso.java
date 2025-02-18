public class Curso {
    String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void iniciar() {
        System.out.println("El curso está arrancando.");
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + nombre);
    }
}