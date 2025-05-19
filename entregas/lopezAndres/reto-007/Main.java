public class Main {
    public static void main(String[] args) {
        Alumno[]alumnos = {
            new Alumno("Pablo", "Rey", "72286467L",7),
            new Alumno("Andrés", "López", "72270491Y", 7),
            new Alumno("Alfredo", "Garcia", "72573487J", 7),
            new Alumno("Sergio", "Quintana", "72200467L",7),
            new Alumno("Lola", "Montero", "72265800N", 7),
            new Alumno("Geremias", "Bermejo", "70003487J", 7)
        };

       Acta actaOriginal = new Acta(alumnos);

        Alumno[]alumnosCambiados = {
            new Alumno("Pablo", "Rey", "72286467L",10),
            new Alumno("Andrés", "López", "72270491Y", 3),
            new Alumno("Alfredo", "Garcia", "72573487J", 7),
            new Alumno("Sergio", "Quintana", "72200467L",7),
            new Alumno("Lola", "Montero", "72265800N", 5),
            new Alumno("Geremias", "Bermejo", "70003487J", 7)
        };

        Acta actaModificada = new Acta(alumnosCambiados);

        for (int i = 0; i < actaOriginal.getHash().length; i++) {
            if(actaOriginal.getHash()[i]!= actaModificada.getHash()[i]){
                System.out.println("Modificacion en: " + actaModificada.getAlumnos(i));
            }
        }
    }
}
