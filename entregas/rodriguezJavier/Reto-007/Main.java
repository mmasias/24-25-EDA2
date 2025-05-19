public class Main {
    public static void main(String[] args) {

        Alumno[] grupo1 = {
            new Alumno("Carlos", "Diaz", "98765432A", 6.8),
            new Alumno("Lucia", "Martinez", "87654321B", 9.2),
            new Alumno("Andres", "Gonzalez", "76543210C", 8.7),
            new Alumno("Sofia", "Lopez", "65432109D", 7.3),
            new Alumno("Miguel", "Hernandez", "54321098E", 6.9),
            new Alumno("Elena", "Garcia", "43210987F", 8.1)
        };

        Alumno[] grupo2 = {
            new Alumno("Raul", "Perez", "98765432A", 7.1),
            new Alumno("Clara", "Sanchez", "87654321B", 8.9),
            new Alumno("Diego", "Fernandez", "76543210C", 7.8),
            new Alumno("Laura", "Torres", "65432109D", 6.7),
            new Alumno("Adrian", "Ruiz", "54321098E", 9.0),
            new Alumno("Valeria", "Morales", "43210987F", 7.5)
        };

        Acta registro1 = new Acta(grupo1);
        Acta registro2 = new Acta(grupo2);

        System.out.println("\nCódigos hash del segundo registro:");
        for (int i = 0; i < registro2.getCodigosHash().length; i++) {
            System.out.println("Estudiante: " + registro2.getEstudiante(i).getNombre() + " " + registro2.getEstudiante(i).getApellido());
            System.out.println("ID: " + registro2.getEstudiante(i).getIdentificacion());
            System.out.println("Calificación: " + registro2.getEstudiante(i).getCalificacion());
            System.out.println("Código Hash: " + registro2.getCodigosHash()[i]);
            System.out.println("******************************");
        }

        System.out.println("\n¿Los registros son idénticos? " + (registro1.esIgual(registro2) ? "Sí" : "No"));
    }
}