package Actas;
import java.util.ArrayList;
import java.util.List;

class SistemaActas {
    
    
    public static void simularSistemaActas() {

        Alumno alumno1 = new Alumno("Javier", "García", "12345678A", 7.5, 8.0, 9.0);
        Alumno alumno2 = new Alumno("Pedro", "Gonzalez", "98765432B", 5.0, 6.5, 7.0);
        Alumno alumno3 = new Alumno("Claudia", "Sánchez", "45678912C", 8.5, 9.0, 8.0);
        Alumno alumno4 = new Alumno("Pablo", "López", "78912345D", 4.0, 5.5, 6.0);
        Alumno alumno5 = new Alumno("María", "Fernández", "32165498E", 9.0, 9.5, 9.0);
        

        Profesor profesor = new Profesor("Juan", "Rodríguez", "Informática");
        

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        

        double promedio = profesor.calcularPromedio(alumnos);
        System.out.println("Promedio calculado por el profesor: " + promedio);
        

        Acta acta = new Acta("EDA2", "24-25", "ordinaria", alumnos, profesor);
        

        System.out.println("Código de verificación: " + acta.getCodigoVerificacion());
        System.out.println("Hash del acta: " + acta.getHash());
        

        System.out.println("¿El acta está íntegra? " + VerificadorActas.verificarActa(acta));
        

        System.out.println("\nDatos de alumnos en el acta:");
        for (Acta.DatosAlumno datosAlumno : acta.getDatosAlumnos()) {
            System.out.println(datosAlumno);
            System.out.println("  Nota Final: " + datosAlumno.getNotaFinal());
            System.out.println("  Componentes: EP(" + datosAlumno.getExamenParcial() + 
                              "), EF(" + datosAlumno.getExamenFinal() + 
                              "), EC(" + datosAlumno.getEvaluacionContinua() + ")");
        }
        

        System.out.println("\nPromedio según el acta: " + acta.calcularPromedio());
        

        String dniBuscar = "45678912C";
        double notaAlumno = acta.obtenerNotaAlumno(dniBuscar);
        
        if (notaAlumno >= 0) {
            System.out.println("\nNota del alumno con DNI " + dniBuscar + ": " + notaAlumno);
        } else {
            System.out.println("\nNo se encontró al alumno con DNI " + dniBuscar);
        }
        

        simularEdicionActa(acta);
        
        
        demostrarManipulacion(acta);
    }
    
   
    private static void simularEdicionActa(Acta acta) {
        System.out.println("\n=== SIMULACIÓN DE EDICIÓN DE ACTA ===");

        EditorActas editor = new EditorActas(acta);
        

        editor.mostrarAlumnos();

       
        System.out.println("\nIntentando editar al alumno con DNI 12345678A:");
        editor.editarAlumno("12345678A");
    }
    
    private static void demostrarManipulacion(Acta acta) {
        System.out.println("\n=== DEMOSTRACIÓN DE SEGURIDAD CONTRA MANIPULACIÓN ===");
        System.out.println("Verificación inicial del acta: " + VerificadorActas.verificarActa(acta));
        System.out.println("Verificación de un acta nula: " + VerificadorActas.verificarActa(null));
        
        System.out.println("El sistema de seguridad mediante hash protege la integridad de las actas.");
    }
}