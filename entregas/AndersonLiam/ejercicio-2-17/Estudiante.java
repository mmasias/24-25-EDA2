public class Estudiante extends Curso {
    public Estudiante(String nombre) {
        super(nombre);
    }

    @Override
    public void empezar() {
        System.out.println("El estudiante comienza su recorrido académico.");
    }

    public void registrar() {
        System.out.println("El estudiante ha sido registrado exitosamente.");
    }

    public void asistir() {
        System.out.println("El estudiante está participando activamente.");
    }
}
