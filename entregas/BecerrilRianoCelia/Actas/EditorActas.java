package Actas;
import java.util.List;

class EditorActas {
    private Acta actaOriginal;

    public EditorActas(Acta acta) {
        this.actaOriginal = acta;
    }

   
    public void editarAlumno(String dni) {
        System.out.println("\n ALERTA DE SEGURIDAD ");
        System.out.println("ERROR: No es posible modificar el acta. El acta es un documento inmutable con un hash de seguridad que garantiza su integridad.");
        System.out.println("Para realizar cambios, se necesita crear una nueva acta.");
    }

 
    public void mostrarAlumnos() {
        List<Acta.DatosAlumno> alumnos = actaOriginal.getDatosAlumnos();
        System.out.println("\nAlumnos en el acta:");
        for (Acta.DatosAlumno alumno : alumnos) {
            System.out.println("- " + alumno.getNombre() + " " + alumno.getApellido() +
                    " (DNI: " + alumno.getDni() + ")");
            System.out.println("  Nota Final: " + alumno.getNotaFinal());
            System.out.println("  Examen Parcial: " + alumno.getExamenParcial());
            System.out.println("  Examen Final: " + alumno.getExamenFinal());
            System.out.println("  Evaluación Continua: " + alumno.getEvaluacionContinua());
        }
    }
}