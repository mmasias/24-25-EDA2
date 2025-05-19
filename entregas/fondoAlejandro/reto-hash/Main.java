public class Main {
    public static void main(String[] args) {
        Estudiante[] datosOriginales = {
            new Estudiante("Claudia", "Santos", "12345678A", 7),
            new Estudiante("Iván", "Domínguez", "23456789B", 7),
            new Estudiante("Lucía", "Molina", "34567890C", 7),
            new Estudiante("Andrés", "Pérez", "45678901D", 7),
            new Estudiante("Valeria", "Nieto", "56789012E", 7),
            new Estudiante("Tomás", "Delgado", "67890123F", 7)
        };

        Acta original = new Acta(datosOriginales);

        Estudiante[] datosActualizados = {
            new Estudiante("Claudia", "Santos", "12345678A", 10),
            new Estudiante("Iván", "Domínguez", "23456789B", 8),
            new Estudiante("Lucía", "Molina", "34567890C", 7),
            new Estudiante("Andrés", "Pérez", "45678901D", 7),
            new Estudiante("Valeria", "Nieto", "56789012E", 5),
            new Estudiante("Tomás", "Delgado", "67890123F", 9)
        };

        Acta modificada = new Acta(datosActualizados);

        for (int i = 0; i < original.obtenerHashes().length; i++) {
            if (original.obtenerHashes()[i] != modificada.obtenerHashes()[i]) {
                System.out.println("Se detectó una modificación en: " + modificada.obtenerEstudiante(i));
            }
        }
    }
}
