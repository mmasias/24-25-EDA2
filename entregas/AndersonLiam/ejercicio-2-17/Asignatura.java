public class Asignatura extends Curso {
    public Asignatura(String nombre) {
        super(nombre);
    }

    @Override
    public void empezar() {
        System.out.println("La asignatura inicia su módulo de aprendizaje.");
    }

    public void asignarProfesor() {
        System.out.println("Un profesor ha sido asignado a esta asignatura.");
    }
}
