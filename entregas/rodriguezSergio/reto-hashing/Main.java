public class Main {
    public static void main(String[] args) {

        Estudiante[] estudiantes = {
            new Estudiante("A001", "Juan", "Pérez", "Matemáticas", 8.5),
            new Estudiante("A002", "Ana", "Gómez", "Física", 9.0)
        };

        Acta actaOriginal = new Acta(estudiantes);
        System.out.println("Código original: " + actaOriginal.getCodigo());

        estudiantes[0] = new Estudiante("A001", "Juan", "Pérez", "Matemáticas", 10.0);

        Acta actaModificada = new Acta(estudiantes);
        System.out.println("Código modificado: " + actaModificada.getCodigo());

        if (!actaOriginal.getCodigo().equals(actaModificada.getCodigo())) {
            System.out.println("¡El acta ha sido modificada!");
        } else {
            System.out.println("El acta no ha cambiado.");
        }
    }
}