public class Alumno {
    private String primerNombre;
    private String primerApellido;
    private float nota;
    private String matricula;
    
    public Alumno(String primerNombre, String primerApellido, String matricula, float nota) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.matricula = matricula;
        this.nota = nota;
    }
    
    public String getPrimerNombre() {
        return primerNombre;
    }
    
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    
    public String getPrimerApellido() {
        return primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public float getNota() {
        return nota;
    }
    
    public void setNota(float nota) {
        this.nota = nota;
    }
    
    @Override
    public int hashCode() {
        return primerNombre.hashCode() ^ primerApellido.hashCode() ^ matricula.hashCode() ^ Float.hashCode(nota);
    }
    
    @Override
    public String toString() {
        return String.format("Alumno[nombre=%s, apellido=%s, matricula=%s, nota=%.2f]", 
                primerNombre, primerApellido, matricula, nota);
    }
}