public class Estudiante {
    private String nombre;
    private String apellido;
    private float calificacion;
    private String identificador;

    public Estudiante(String nombre, String apellido, String identificador, float calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificador = identificador;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() ^ apellido.hashCode() ^ identificador.hashCode() ^ Float.hashCode(calificacion);
    }

    @Override
    public String toString() {
        return String.format("Estudiante[nombre=%s, apellido=%s, id=%s, calificación=%.2f]", nombre, apellido, identificador, calificacion);
    }
}
