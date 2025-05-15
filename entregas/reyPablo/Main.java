public class Main {
    public static void main(String[] args) {
        Alumno [] alumnos={
            new Alumno("Pablo", "Rey", "72224668E", 7),
            new Alumno("Mario", "Viadero", "72226965E", 8),
            new Alumno("Miguel", "Andeco", "72326674E", 6),
            new Alumno("Juan", "Leon", "13227662E", 4),
            new Alumno("Alfredo", "Martinez", "13790363T", 10),
            new Alumno("Luis", "Rodriguez", "73334559G", 3)
        };
        Acta actaOriginal=new Acta(alumnos);

        Alumno [] alumnosCambiados={
            new Alumno("Pablo", "Rey", "72224668E", 9),
            new Alumno("Mario", "Viadero", "72226965E", 8),
            new Alumno("Miguel", "Andeco", "72326674E", 6),
            new Alumno("Juan", "Leon", "13227662E", 6),
            new Alumno("Fernando", "Martinez", "13790363T", 10),
            new Alumno("Luis", "Rodriguez", "73334559G", 5)
        };
        Acta actaModificada=new Acta(alumnosCambiados);

        for (int i = 0; i < actaOriginal.getHash().length; i++) {
            if (actaOriginal.getHash()[i]!=actaModificada.getHash()[i]) {
                System.out.println("Modificacion en " + actaModificada.getAlumno(i));
            }
            
        }
    }
}
