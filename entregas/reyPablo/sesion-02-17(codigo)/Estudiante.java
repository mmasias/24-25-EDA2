public class Estudiante extends Curso {
    public Estudiante(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("El estudiante comienza su participación en el curso.");
    }

    public void inscribirse() {
        System.out.println("Inscripción completada.");
    }

    public void asistirClase() {
        System.out.println("El estudiante está asistiendo a clase.");
    }
}