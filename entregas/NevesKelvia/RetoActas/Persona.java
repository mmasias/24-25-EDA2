package entregas.NevesKelvia.RetoActas;

public class Persona {
    private String nombreCompleto;
    private String numeroCarnet;
    private double notaParcial;
    private double notaContinua;
    private double notaFinal;

    public Persona(String nombreCompleto, String numeroCarnet) {
        this.nombreCompleto = nombreCompleto;
        this.numeroCarnet = numeroCarnet;
    }

    public void asignarNotas(double notaParcial, double notaContinua, double notaFinal) {
        this.notaParcial = notaParcial;
        this.notaContinua = notaContinua;
        this.notaFinal = notaFinal;
    }

    public double calcularPromedio() {
        return (notaParcial + notaContinua + notaFinal) / 3.0;
    }

    public String obtenerResumenNotas() {
        return nombreCompleto + " (" + numeroCarnet + ") - Promedio: " + calcularPromedio();
    }

    public double getNotaParcial() {
        return notaParcial;
    }

    public double getNotaContinua() {
        return notaContinua;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroCarnet() {
        return numeroCarnet;
    }
}
