package entregas.martinezDiego.hash;

final class Acta {
    public static void main(String[] args) {
        DatosAlumno[] alumnos = {
                new DatosAlumno("Carlos", "Martínez", 12345678, "EDA2", 9.0),
                new DatosAlumno("Lucía", "Gómez", 87654321, "EDA2", 8.0),
                new DatosAlumno("Juan", "Fernandez", 46678738, "EDA2", 4.0),
        };

        System.out.println("-- ASIGNATURA: " + alumnos[0].getAsignatura() + " --");

        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("ALUMNO: " + alumnos[i].getNombreAlumno() + " " + alumnos[i].getApellidosAlumno() + " "
                    + " ID: " + alumnos[i].getIdAlumno() + " " + "NOTA FINAL " + alumnos[i].getNotaFinal());
        }

        String hash = Hashing.generarHash(alumnos);
        System.out.println("Código hash: " + hash);

    }
}
