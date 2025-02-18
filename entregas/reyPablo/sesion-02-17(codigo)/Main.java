public class Main {
    public static void main(String[] args) {
        Curso[] cursos = new Curso[3];
        cursos[0] = new Estudiante("Ana");
        cursos[1] = new Asignatura("Historia");
        cursos[2] = new Profesor("Dr. Pérez");

        for (Curso curso : cursos) {
            curso.iniciar();

            if (curso instanceof Estudiante) {
                ((Estudiante) curso).inscribirse();
                ((Estudiante) curso).asistirClase();
            }

            if (curso instanceof Asignatura) {
                ((Asignatura) curso).asignarProfesor();
            }

            System.out.println();
        }

        Asignatura miAsignatura = new Asignatura("Literatura");
        miAsignatura.mostrarInfo();

        Curso asignatura1 = new Asignatura("Matemáticas");
        Curso asignatura2 = new Asignatura("Matemáticas");
        System.out.println("¿Coinciden los cursos? " + asignatura1.equals(asignatura2));
    }
}