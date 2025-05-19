public class Alumno{

    private String nombre;
    private String apellidos;
    private double nota;
    private String dni;


    public Alumno(String nombre, String apellidos,String dni, double nota){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.nota = nota;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " " + apellidos + ", nota: " + nota + ", dni: " + dni;
    }


}