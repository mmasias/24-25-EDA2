package Actas;
import java.util.List;
class Profesor {
    private final String nombre;
    private final String apellido;
    private final String departamento;

    public Profesor(String nombre, String apellido, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public double calcularPromedio(List<Alumno> alumnos) {
        if (alumnos == null || alumnos.isEmpty()) {
            return 0;
        }
        
        double sumaNotas = 0;
        for (Alumno alumno : alumnos) {
            sumaNotas += alumno.calcularNotaFinal();
        }
        
        return sumaNotas / alumnos.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }
}
