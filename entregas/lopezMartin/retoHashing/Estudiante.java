package entregas.lopezMartin.retoHashing;

public class Estudiante {

    private String nombre;
    private String apellidos;
    private double notaExParcial;
    private double notaExFinal;
    private double notaEvContinua;
    private double notaProfesor;
    private double notaFinal;

    public Estudiante(String nombre, String apellidos, double notaParcial, double notaFinal, double notaEvContinua, double notaProfesor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notaExParcial = notaParcial;
        this.notaExFinal = notaFinal;
        this.notaEvContinua = notaEvContinua;
        this.notaProfesor = notaProfesor;
        this.notaFinal = calcularNotaFinal();

    }

    private double calcularNotaFinal() {
        return (this.notaExParcial * 0.25) + (this.notaExFinal * 0.5) + (this.notaEvContinua * 0.2) + (this.notaProfesor * 0.05);
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public double getNotaExParcial() {
        return notaExParcial;
    }
    public double getNotaExFinal() {
        return notaExFinal;
    }
    public double getNotaEvContinua() {
        return notaEvContinua;
    }
    public double getNotaProfesor() {
        return notaProfesor;
    }
    public double getNotaFinal() {
        return notaFinal;
    }
    
}