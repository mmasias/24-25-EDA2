public class Curso {
    String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void empezar() {
        System.out.println("El curso está comenzando su ciclo.");
    }

    public void mostrarDetalles() {
        System.out.println("Detalles del curso: " + nombre);
    }
}
