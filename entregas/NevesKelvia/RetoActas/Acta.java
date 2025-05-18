package entregas.NevesKelvia.RetoActas;

import java.util.List;

public class Acta {
    private String nombreAsignatura;
    private String periodoCurso;
    private String nombreProfesor;
    private List<Persona> listaAlumnos;
    private boolean actaFueGenerada = false;
    private int hashContenidoOriginal;

    public Acta(String nombreAsignatura, String periodoCurso, String nombreProfesor, List<Persona> listaAlumnos) {
        this.nombreAsignatura = nombreAsignatura;
        this.periodoCurso = periodoCurso;
        this.nombreProfesor = nombreProfesor;
        this.listaAlumnos = listaAlumnos;
    }

    public void generarActa() {
        if (actaFueGenerada) {
            System.out.println("El acta ya fue generada anteriormente.");
            return;
        }

        System.out.println("Generando acta para: " + nombreAsignatura + " (" + periodoCurso + ")");
        System.out.println("Profesor responsable: " + nombreProfesor);
        System.out.println("Listado de alumnos:");

        for (Persona alumno : listaAlumnos) {
            System.out.println(alumno.obtenerResumenNotas());
        }

        String contenidoActa = generarContenidoActaParaHash();
        hashContenidoOriginal = contenidoActa.hashCode();
        actaFueGenerada = true;

        System.out.println("Acta generada correctamente.\n");
    }

    public void verificarIntegridad() {
        String contenidoActual = generarContenidoActaParaHash();
        int hashActual = contenidoActual.hashCode();

        if (hashActual != hashContenidoOriginal) {
            System.out.println("Advertencia: El contenido del acta ha sido modificado después de su generación.");
        } else {
            System.out.println("El acta permanece sin cambios.");
        }
    }

    public boolean fueGenerada() {
        return actaFueGenerada;
    }

    private String generarContenidoActaParaHash() {
        String contenido = "";

        for (Persona alumno : listaAlumnos) {
            contenido = contenido +
                    alumno.getNombreCompleto() +
                    alumno.getNumeroCarnet() +
                    alumno.getNotaParcial() +
                    alumno.getNotaContinua() +
                    alumno.getNotaFinal();
        }

        contenido = contenido + nombreAsignatura + periodoCurso + nombreProfesor;

        return contenido;
    }
}
