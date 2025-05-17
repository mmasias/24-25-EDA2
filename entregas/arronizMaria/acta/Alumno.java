package acta;

class Alumno {
    private final String nombre;
    private final String apellido;
    private final Nota nota;

    public Alumno(String nombre, String apellido, Nota nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Nota getNota() {
        return nota;
    }
}
