public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private String curso;
    private double nota;

    public Estudiante(String id, String nombre, String apellido, String curso, double nota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCurso() {
        return curso;
    }
    
    public double getNota() {
        return nota;
    }
}