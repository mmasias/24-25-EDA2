public class Main {
    public static void main(String[] args) {
        Alumno[] alumnos = {
            new Alumno("Lucía", "Martínez", "12345678A", 6),
            new Alumno("Carlos", "Ruiz", "87654321B", 5),
            new Alumno("Elena", "Torres", "11223344C", 8),
            new Alumno("Javier", "López", "44332211D", 9),
            new Alumno("Marta", "Sánchez", "55667788E", 4),
            new Alumno("Andrés", "Moreno", "99887766F", 7)
        };

        Acta actaOriginal = new Acta(alumnos);

        Alumno[] alumnosCambiados = {
            new Alumno("Lucía", "Martínez", "12345678A", 9),
            new Alumno("Carlos", "Ruiz", "87654321B", 3),
            new Alumno("Elena", "Torres", "11223344C", 8),
            new Alumno("Javier", "López", "44332211D", 9),
            new Alumno("Marta", "Sánchez", "55667788E", 6),
            new Alumno("Andrés", "Moreno", "99887766F", 7)
        };

        Acta actaModificada = new Acta(alumnosCambiados);

        for (int i = 0; i < actaOriginal.getHash().length; i++) {
            if (actaOriginal.getHash()[i] != actaModificada.getHash()[i]) {
                System.out.println("Modificación en: " + actaModificada.getAlumnos(i));
            }
        }
    }
}
