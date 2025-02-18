public class Main {
    public static void main(String[] args) {
        Curso[] cursos = new Curso[3];
        cursos[0] = new Estudiante("Carlos");
        cursos[1] = new Asignatura("Matemáticas");
        cursos[2] = new Profesor("Dr. González");

        for (Curso curso : cursos) {
            curso.empezar();

            if (curso instanceof Estudiante) {
                ((Estudiante) curso).registrar();
                ((Estudiante) curso).asistir();
            }

            if (curso instanceof Asignatura) {
                ((Asignatura) curso).asignarProfesor();
            }

            System.out.println();
        }

        Asignatura miAsignatura = new Asignatura("Física");
        miAsignatura.mostrarDetalles();

        Curso asignatura1 = new Asignatura("Química");
        Curso asignatura2 = new Asignatura("Química");
        System.out.println("¿Son iguales las asignaturas? " + asignatura1.equals(asignatura2));
    }
}
