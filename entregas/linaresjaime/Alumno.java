package entregas.linaresjaime;

public class Alumno {
    String dni;
    String nombre;
    double notaParcial;
    double notaFinal;
    double notaGlobal;

    public Alumno(String dni, String nombre, double notaParcial, double notaFinal) {
        this.dni = dni;
        this.nombre = nombre;
        this.notaParcial = notaParcial;
        this.notaFinal = notaFinal;
        calcularNotaGlobal();
    }

    public void calcularNotaGlobal() {
        this.notaGlobal = (0.4 * notaParcial) + (0.6 * notaFinal);
    }

    public void mostrarDatos() {
        System.out.println("DNI: " + dni + " | Nombre: " + nombre +
                           " | Parcial: " + notaParcial +
                           " | Final: " + notaFinal +
                           " | Global: " + notaGlobal);
    }
}
