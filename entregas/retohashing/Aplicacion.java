public class Aplicacion {
    public static void main(String[] args) {
        Alumno[] datosIniciales = {
            new Alumno("Claudia", "Santos", "12345678A", 7),
            new Alumno("Iván", "Domínguez", "23456789B", 7),
            new Alumno("Lucía", "Molina", "34567890C", 7),
            new Alumno("Andrés", "Pérez", "45678901D", 7),
            new Alumno("Valeria", "Nieto", "56789012E", 7),
            new Alumno("Tomás", "Delgado", "67890123F", 7)
        };
        
        RegistroAcademico registroInicial = new RegistroAcademico(datosIniciales);
        
        Alumno[] datosFinales = {
            new Alumno("Claudia", "Santos", "12345678A", 10),
            new Alumno("Iván", "Domínguez", "23456789B", 8),
            new Alumno("Lucía", "Molina", "34567890C", 7),
            new Alumno("Andrés", "Pérez", "45678901D", 7),
            new Alumno("Valeria", "Nieto", "56789012E", 5),
            new Alumno("Tomás", "Delgado", "67890123F", 9)
        };
        
        RegistroAcademico registroFinal = new RegistroAcademico(datosFinales);
        
        for (int idx = 0; idx < registroInicial.obtenerDigests().length; idx++) {
            if (registroInicial.obtenerDigests()[idx] != registroFinal.obtenerDigests()[idx]) {
                System.out.println("Cambio detectado en: " + registroFinal.consultarAlumno(idx));
            }
        }
    }
}