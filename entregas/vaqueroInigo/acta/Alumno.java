public class Alumno {
    private String nombre;
    private String apellido;
    private String dni;
    private int nota;

    public Alumno(String nombre, String apellido, String dni, int nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + dni + ") - Nota: " + nota;
    }

    public int getHash() {
        return (nombre + apellido + dni + nota).hashCode();
    }
}
