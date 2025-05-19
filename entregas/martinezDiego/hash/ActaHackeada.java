package entregas.martinezDiego.hash;

public class ActaHackeada extends Acta {

    public static void main(String[] args) {
        DatosAlumno[] alumnos = {
                new DatosAlumno("Carlos", "Martínez", 12345678, "EDA2", 9.0),
                new DatosAlumno("Lucía", "Gómez", 87654321, "EDA2", 8.0),
                new DatosAlumno("Juan", "Fernandez", 46678738, "EDA2", 4.0),
        };

        String hash = Hashing.generarHash(alumnos);

        alumnos[2].setNotaFinal(10.0);

        System.out.println("-- ACTA HACKEADA --");
        System.out.println("-- ASIGNATURA: " + alumnos[0].getAsignatura() + " --");

        for (DatosAlumno alumno : alumnos) {
            System.out.println("ALUMNO: " + alumno.getNombreAlumno() + " " + alumno.getApellidosAlumno() + " "
                    + "ID: " + alumno.getIdAlumno() + " NOTA FINAL: " + alumno.getNotaFinal());
        }

        System.out.println("Código hash: " + hash);
    }
}
