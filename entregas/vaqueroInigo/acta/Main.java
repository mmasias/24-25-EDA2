public class Main {
    public static void main(String[] args) {
        Alumno[] alumnos = {
            new Alumno("Carlos", "García", "12345678A", 6),
            new Alumno("Lucía", "Pérez", "87654321B", 7),
            new Alumno("Elena", "Santos", "11223344C", 5),
            new Alumno("Diego", "López", "22334455D", 8),
            new Alumno("Jorge", "Hernández", "33445566E", 9),
            new Alumno("Marta", "Ruiz", "44556677F", 4)
        };
        Acta actaOriginal = new Acta(alumnos);

        Alumno[] alumnosCambiados = {
            new Alumno("Carlos", "García", "12345678A", 7),
            new Alumno("Lucía", "Pérez", "87654321B", 7),
            new Alumno("Elena", "Santos", "11223344C", 5),
            new Alumno("Diego", "López", "22334455D", 6),
            new Alumno("Julia", "Hernández", "33445566E", 9),
            new Alumno("Marta", "Ruiz", "44556677F", 6)
        };
        Acta actaModificada = new Acta(alumnosCambiados);

        for (int i = 0; i < actaOriginal.getHash().length; i++) {
            if (actaOriginal.getHash()[i] != actaModificada.getHash()[i]) {
                System.out.println("Modificación en " + actaModificada.getAlumno(i));
            }
        }
    }
}

