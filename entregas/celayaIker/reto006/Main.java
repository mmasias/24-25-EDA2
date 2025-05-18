package entregas.celayaIker.reto006;

public class Main {
    public static void main(String[] args) {
        Acta acta = new Acta();

        acta.agregarAlumno(new Alumno("Laura", "Gómez", "Ramos", 8.5, 7.0, 9.0));
        acta.agregarAlumno(new Alumno("Carlos", "Martínez", "Núñez", 7.2, 6.8, 8.0));
        acta.agregarAlumno(new Alumno("Ana", "Pérez", "Santos", 9.0, 8.5, 9.3));
        acta.agregarAlumno(new Alumno("Miguel", "Sánchez", "Delgado", 6.0, 6.5, 7.2));
        acta.agregarAlumno(new Alumno("Lucía", "Ruiz", "Cordero", 8.8, 7.7, 8.9));
        acta.agregarAlumno(new Alumno("David", "Fernández", "Moreno", 5.9, 6.1, 6.5));
        acta.agregarAlumno(new Alumno("Sara", "López", "Castro", 9.5, 9.2, 9.8));
        acta.agregarAlumno(new Alumno("Juan", "García", "Romero", 7.8, 7.0, 8.3));
        acta.agregarAlumno(new Alumno("Elena", "Díaz", "Vargas", 8.0, 8.2, 8.5));
        acta.agregarAlumno(new Alumno("Jorge", "Morales", "Iglesias", 6.5, 7.3, 7.8));

        acta.cerrarActa();

        System.out.println("Modificando la nota final de Carlos...");
        acta.getAlumnos().get(1).setExamenFinal(10.0); 

        acta.verificarIntegridad();
    }
}
