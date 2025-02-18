public class Asignatura extends Curso {
    public Asignatura(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("La asignatura inicia su sesión.");
    }

    public void asignarProfesor() {
        System.out.println("Profesor asignado a la asignatura.");
    }
}